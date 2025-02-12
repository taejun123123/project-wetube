package com.archive.test.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Generated;

@Entity
public class RefreshToken {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;
  
  @Column(name = "user_id", nullable = false, unique = true)
  private Long userId;
  
  @Column(name = "refresh_token", nullable = false)
  private String refreshToken;
  
  @Generated
  protected RefreshToken() {}
  
  @Generated
  public Long getId() {
    return this.id;
  }
  
  @Generated
  public Long getUserId() {
    return this.userId;
  }
  
  @Generated
  public String getRefreshToken() {
    return this.refreshToken;
  }
  
  @Generated
  public static RefreshTokenBuilder builder() {
    return new RefreshTokenBuilder();
  }
  
  public RefreshToken(Long userId, String refreshToken) {
    this.userId = userId;
    this.refreshToken = refreshToken;
  }
  
  public com.archive.test.entity.RefreshToken update(String newRefreshToken) {
    this.refreshToken = newRefreshToken;
    return this;
  }
}
