package com.example.jwt.domain.user;

import com.example.jwt.core.generic.ExtendedService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, ExtendedService<User> {

  User register(User user);
}
