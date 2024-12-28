package com.archive.test.service;

import com.archive.test.service.JwtToken;
import lombok.Generated;

@Generated
public class JwtTokenBuilder {
  @Generated
  private String accessToken;
  
  @Generated
  private String refreshToken;
  
  @Generated
  public JwtTokenBuilder accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
  
  @Generated
  public JwtTokenBuilder refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
  
  @Generated
  public JwtToken build() {
    return new JwtToken(this.accessToken, this.refreshToken);
  }
  
  @Generated
  public String toString() {
    return "JwtToken.JwtTokenBuilder(accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ")";
  }
}
