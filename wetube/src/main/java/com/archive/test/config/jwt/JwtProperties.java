package com.archive.test.config.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Generated;

@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
  private String issuer;
  
  private String secretKey;
  
  @Generated
  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }
  
  @Generated
  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }
  
  @Generated
  public String getIssuer() {
    return this.issuer;
  }
  
  @Generated
  public String getSecretKey() {
    return this.secretKey;
  }
}
