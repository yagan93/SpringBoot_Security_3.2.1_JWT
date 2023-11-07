package com.example.jwt.core.generic;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtendedRepository<T extends ExtendedEntity> extends JpaRepository<T, UUID> {

}
