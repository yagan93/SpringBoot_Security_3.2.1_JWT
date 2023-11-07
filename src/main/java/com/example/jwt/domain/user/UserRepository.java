package com.example.jwt.domain.user;

import com.example.jwt.core.generic.ExtendedRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ExtendedRepository<User> {

  Optional<User> findByEmail(String email);
}
