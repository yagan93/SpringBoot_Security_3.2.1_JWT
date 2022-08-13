package com.example.jwt.core.generic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExtendedRepository<T extends ExtendedEntity> extends JpaRepository<T, UUID> {
}
