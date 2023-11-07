package com.example.jwt.core.generic;

import com.example.jwt.domain.user.User;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ExtendedAuditEntity extends ExtendedEntity {

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "created_by")
  @CreatedBy
  private User createdBy;

  @LastModifiedDate
  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

  @ManyToOne
  @JoinColumn(name = "last_modified_by")
  @LastModifiedBy
  private User lastModifiedBy;

  protected ExtendedAuditEntity() {
  }

  protected ExtendedAuditEntity(UUID id) {
    super(id);
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public ExtendedAuditEntity setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public ExtendedAuditEntity setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public LocalDateTime getModifiedAt() {
    return modifiedAt;
  }

  public ExtendedAuditEntity setModifiedAt(LocalDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

  public User getLastModifiedBy() {
    return lastModifiedBy;
  }

  public ExtendedAuditEntity setLastModifiedBy(User lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
    return this;
  }
}
