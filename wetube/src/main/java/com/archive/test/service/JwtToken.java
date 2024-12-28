package com.archive.test.service;

import lombok.Generated;

public class JwtToken {
  private String accessToken;
  
  private String refreshToken;
  
  @Generated
  public String getAccessToken() {
    return this.accessToken;
  }
  
  @Generated
  public String getRefreshToken() {
    return this.refreshToken;
  }
  
  @Generated
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
  
  @Generated
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
  
  @Generated
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.archive.test.service.JwtToken))
      return false; 
    com.archive.test.service.JwtToken other = (com.archive.test.service.JwtToken)o;
    if (!other.canEqual(this))
      return false; 
    Object this$accessToken = getAccessToken(), other$accessToken = other.getAccessToken();
    if ((this$accessToken == null) ? (other$accessToken != null) : !this$accessToken.equals(other$accessToken))
      return false; 
    Object this$refreshToken = getRefreshToken(), other$refreshToken = other.getRefreshToken();
    return !((this$refreshToken == null) ? (other$refreshToken != null) : !this$refreshToken.equals(other$refreshToken));
  }
  
  @Generated
  protected boolean canEqual(Object other) {
    return other instanceof com.archive.test.service.JwtToken;
  }
  
  
  @Generated
  public String toString() {
    return "JwtToken(accessToken=" + getAccessToken() + ", refreshToken=" + getRefreshToken() + ")";
  }
  
  @Generated
  public static JwtTokenBuilder builder() {
    return new JwtTokenBuilder();
  }
  
  @Generated
  public JwtToken(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }
}
