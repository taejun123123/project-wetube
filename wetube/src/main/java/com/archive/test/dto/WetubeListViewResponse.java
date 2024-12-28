package com.archive.test.dto;


import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import java.time.LocalDateTime;
import lombok.Generated;

public class WetubeListViewResponse {
  private final Long id;
  
  private final String saved_path;
  
  private final String content;
  
  private final String title;
  
  private final Long hit;
  
  private final User user;
  
  private String userNickname;
  
  private String userProfile;
  
  private LocalDateTime createdAt;
  
  private Long user_id;
  
  @Generated
  public Long getUser_id() {
    return this.user_id;
  }
  
  @Generated
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }
  
  @Generated
  public String getUserProfile() {
    return this.userProfile;
  }
  
  @Generated
  public String getUserNickname() {
    return this.userNickname;
  }
  
  @Generated
  public User getUser() {
    return this.user;
  }
  
  @Generated
  public Long getHit() {
    return this.hit;
  }
  
  @Generated
  public String getTitle() {
    return this.title;
  }
  
  @Generated
  public String getContent() {
    return this.content;
  }
  
  @Generated
  public String getSaved_path() {
    return this.saved_path;
  }
  
  @Generated
  public Long getId() {
    return this.id;
  }
  
  public WetubeListViewResponse(Wetube wetube) {
    this.id = wetube.getId();
    this.saved_path = wetube.getSavedPath();
    this.hit = wetube.getHit();
    this.title = wetube.getTitle();
    this.content = wetube.getContent();
    this.user = wetube.getUser();
    this.userNickname = wetube.getUser().getNickname();
    this.userProfile = wetube.getUser().getProfile();
    this.createdAt = wetube.getCreatedAt();
    this.user_id = wetube.getUser().getId();
  }
}
