package com.archive.test.entity;


import com.archive.test.entity.User;
import lombok.Generated;

@Generated
public class UserBuilder {
  @Generated
  private Long id;
  
  @Generated
  private String email;
  
  @Generated
  private String password;
  
  @Generated
  private String auth;
  
  @Generated
  private String profile;
  
  @Generated
  private String nickname;
  
  @Generated
  public UserBuilder id(Long id) {
    this.id = id;
    return this;
  }
  
  @Generated
  public UserBuilder email(String email) {
    this.email = email;
    return this;
  }
  
  @Generated
  public UserBuilder password(String password) {
    this.password = password;
    return this;
  }
  
  @Generated
  public UserBuilder auth(String auth) {
    this.auth = auth;
    return this;
  }
  
  @Generated
  public UserBuilder profile(String profile) {
    this.profile = profile;
    return this;
  }
  
  @Generated
  public UserBuilder nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }
  
  @Generated
  public String toString() {
    return "User.UserBuilder(id=" + String.valueOf(this.id) + ", email=" + this.email + ", password=" + this.password + ", auth=" + this.auth + ", profile=" + this.profile + ", nickname=" + this.nickname + ")";
  }

public Object build() {
	// TODO Auto-generated method stub
	return null;
}
}

