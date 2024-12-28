package com.archive.test.dto;

import lombok.Generated;

public class CreateAccessTokenResponse {
  private String accessToken;
  
  @Generated
  public CreateAccessTokenResponse(String accessToken) {
    this.accessToken = accessToken;
  }
  
  @Generated
  public String getAccessToken() {
    return this.accessToken;
  }
}
