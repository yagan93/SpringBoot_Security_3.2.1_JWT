package com.example.jwt.core.security.helpers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
public class JwtProperties {

  private long expirationMillis;
  private String issuer;
  private String secret;

  public JwtProperties() {
  }

  public JwtProperties(long expirationMillis, String issuer, String secret) {
    this.expirationMillis = expirationMillis;
    this.issuer = issuer;
    this.secret = secret;
  }

  public long getExpirationMillis() {
    return expirationMillis;
  }

  public JwtProperties setExpirationMillis(long expirationMillis) {
    this.expirationMillis = expirationMillis;
    return this;
  }

  public String getIssuer() {
    return issuer;
  }

  public JwtProperties setIssuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  public String getSecret() {
    return secret;
  }

  public JwtProperties setSecret(String secret) {
    this.secret = secret;
    return this;
  }
}
