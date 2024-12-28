package com.archive.test.dto;


import lombok.Generated;

public class AddUserRequest {
  private String email;
  
  private String password;
  
  private String nickname;
  
  @Generated
  public void setEmail(String email) {
    this.email = email;
  }
  
  @Generated
  public void setPassword(String password) {
    this.password = password;
  }
  
  @Generated
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  
  @Generated
  public String getEmail() {
    return this.email;
  }
  
  @Generated
  public String getPassword() {
    return this.password;
  }
  
  @Generated
  public String getNickname() {
    return this.nickname;
  }
}
