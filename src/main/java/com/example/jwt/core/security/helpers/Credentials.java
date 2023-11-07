package com.example.jwt.core.security.helpers;

public class Credentials {

  private String email;
  private String password;

  public Credentials() {
  }

  public String getEmail() {
    return email;
  }

  public Credentials setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Credentials setPassword(String password) {
    this.password = password;
    return this;
  }
}
