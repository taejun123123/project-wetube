package com.archive.test.dto;


import lombok.Generated;

public class CreateAccessTokenRequest {
  private String refreshToken;
  
  @Generated
  public String getRefreshToken() {
    return this.refreshToken;
  }
  
  @Generated
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
