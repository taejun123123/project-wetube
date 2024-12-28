package com.archive.test.dto;


import com.archive.test.entity.Wetube;
import java.time.LocalDateTime;
import lombok.Generated;

public class WetubeResponse {
  private Long id;
  
  private String saved_path;
  
  private String content;
  
  private String title;
  
  private Long hit;
  
  private String userNickname;
  
  private String userProfile;
  
  private LocalDateTime createdAt;
  
  private Long userSubscriber;
  
  private int likes;
  
  private Long user_id;
  
  @Generated
  public Long getId() {
    return this.id;
  }
  
  @Generated
  public String getSaved_path() {
    return this.saved_path;
  }
  
  @Generated
  public String getContent() {
    return this.content;
  }
  
  @Generated
  public String getTitle() {
    return this.title;
  }
  
  @Generated
  public Long getHit() {
    return this.hit;
  }
  
  @Generated
  public String getUserNickname() {
    return this.userNickname;
  }
  
  @Generated
  public String getUserProfile() {
    return this.userProfile;
  }
  
  @Generated
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }
  
  @Generated
  public Long getUserSubscriber() {
    return this.userSubscriber;
  }
  
  @Generated
  public int getLikes() {
    return this.likes;
  }
  
  @Generated
  public Long getUser_id() {
    return this.user_id;
  }
  
  @Generated
  public WetubeResponse() {}
  
  public WetubeResponse(Wetube wetube) {
    this.id = wetube.getId();
    this.saved_path = wetube.getSavedPath();
    this.hit = wetube.getHit();
    this.title = wetube.getTitle();
    this.content = wetube.getContent();
    this.userNickname = wetube.getUser().getNickname();
    this.userProfile = wetube.getUser().getProfile();
    this.userSubscriber = wetube.getUser().getSubscriber();
    this.createdAt = wetube.getCreatedAt();
    this.likes = wetube.getLikes();
    this.user_id = wetube.getUser().getId();
  }
}
