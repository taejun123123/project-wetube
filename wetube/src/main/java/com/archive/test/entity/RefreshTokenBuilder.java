package com.archive.test.entity;


import com.archive.test.entity.RefreshToken;
import lombok.Generated;

@Generated
public class RefreshTokenBuilder {
  @Generated
  private Long userId;
  
  @Generated
  private String refreshToken;
  
  @Generated
  public RefreshTokenBuilder userId(Long userId) {
    this.userId = userId;
    return this;
  }
  
  @Generated
  public RefreshTokenBuilder refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
  
  @Generated
  public RefreshToken build() {
    return new RefreshToken(this.userId, this.refreshToken);
  }
  
  @Generated
  public String toString() {
    return "RefreshToken.RefreshTokenBuilder(userId=" + String.valueOf(this.userId) + ", refreshToken=" + this.refreshToken + ")";
  }
}
