package com.example.infra.jpa;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.persistence.Column;

@MappedSuperclass
@EntityListeners(value = BaseEntityListener.class)
public class BaseEntity {

  @Column(name = "created_date", updatable = false)
  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

  @Column(name = "created_by", updatable = false)
  private String createdBy;

  private String updatedBy;

  private long version;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Version
  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

}
