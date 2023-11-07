package com.example.jwt.core.security;

import com.example.jwt.core.security.helpers.AuthorizationSchemas;
import com.example.jwt.core.security.helpers.Credentials;
import com.example.jwt.core.security.helpers.JwtProperties;
import com.example.jwt.domain.user.UserDetailsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  private final JwtProperties jwtProperties;

  public CustomAuthenticationFilter(RequestMatcher requestMatcher,
      AuthenticationManager authenticationManager, JwtProperties jwtProperties) {
    super(requestMatcher, authenticationManager);
    this.jwtProperties = jwtProperties;
  }

  private String generateToken(Authentication authResult) {
    UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
    byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

    return Jwts.builder()
        .claims(Map.of("sub", userDetailsImpl.user().getId().toString(), "authorities",
            userDetailsImpl.getAuthorities()))
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
        .issuer(jwtProperties.getIssuer())
        .signWith(Keys.hmacShaKeyFor(keyBytes))
        .compact();
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response)
      throws AuthenticationException, IOException {
    Credentials credentials = new ObjectMapper().readValue(request.getInputStream(),
        Credentials.class);
    return getAuthenticationManager()
        .authenticate(new UsernamePasswordAuthenticationToken(credentials.getEmail(),
            credentials.getPassword()));
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain,
      Authentication authResult) {
    response.addHeader(HttpHeaders.AUTHORIZATION,
        AuthorizationSchemas.BEARER + " " + generateToken(authResult));
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request,
      HttpServletResponse response, AuthenticationException failed) {
    SecurityContextHolder.clearContext();
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
  }
}
