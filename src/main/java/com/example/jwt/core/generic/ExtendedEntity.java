package com.example.jwt.core.generic;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class ExtendedEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  protected ExtendedEntity() {
  }

  protected ExtendedEntity(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  public ExtendedEntity setId(UUID id) {
    this.id = id;
    return this;
  }
}