package com.example.jwt.core.security;

import com.example.jwt.core.security.helpers.AuthorizationSchemas;
import com.example.jwt.core.security.helpers.JwtProperties;
import com.example.jwt.domain.user.UserDetailsImpl;
import com.example.jwt.domain.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

  private final UserService userService;
  private final JwtProperties jwtProperties;

  public CustomAuthorizationFilter(UserService userService, JwtProperties jwtProperties) {
    this.userService = userService;
    this.jwtProperties = jwtProperties;
  }

  private String resolveToken(String token) {
    if (token != null && token.startsWith(AuthorizationSchemas.BEARER.toString())) {
      byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
      return Jwts.parser()
          .verifyWith(Keys.hmacShaKeyFor(keyBytes))
          .build()
          .parseSignedClaims(token.replace(AuthorizationSchemas.BEARER + " ", ""))
          .getPayload()
          .getSubject();
    } else {
      return null;
    }
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      String authToken = request.getHeader(HttpHeaders.AUTHORIZATION);
      UserDetails userDetails = new UserDetailsImpl(
          userService.findById(UUID.fromString(resolveToken(authToken))));
      SecurityContextHolder.getContext().setAuthentication(
          new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
    } catch (Exception e) {
      SecurityContextHolder.clearContext();
    }
    filterChain.doFilter(request, response);
  }
}
