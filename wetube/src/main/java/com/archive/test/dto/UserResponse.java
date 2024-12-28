package com.archive.test.dto;


import com.archive.test.entity.User;
import lombok.Generated;

public class UserResponse {
  private Long id;
  
  private String email;
  
  private String profile;
  
  private String nickname;
  
  @Generated
  public Long getId() {
    return this.id;
  }
  
  @Generated
  public String getEmail() {
    return this.email;
  }
  
  @Generated
  public String getProfile() {
    return this.profile;
  }
  
  @Generated
  public String getNickname() {
    return this.nickname;
  }
  
  @Generated
  public UserResponse() {}
  
  public UserResponse(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.profile = user.getProfile();
    this.nickname = user.getNickname();
  }
}
