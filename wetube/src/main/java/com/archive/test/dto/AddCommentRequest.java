package com.archive.test.dto;


import com.archive.test.entity.Wetube;
import com.archive.test.entity.WetubeComment;
import lombok.Generated;

public class AddCommentRequest {
  private Long commentId;
  
  private Long commentLikes;
  
  private String body;
  
  private String nickName;
  
  private String profileImage;
  
  private Wetube wetube;
  
  private Long wetubeId;
  
  private Long userId;
  
  @Generated
  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }
  
  @Generated
  public void setCommentLikes(Long commentLikes) {
    this.commentLikes = commentLikes;
  }
  
  @Generated
  public void setBody(String body) {
    this.body = body;
  }
  
  @Generated
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  
  @Generated
  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }
  
  @Generated
  public void setWetube(Wetube wetube) {
    this.wetube = wetube;
  }
  
  @Generated
  public void setWetubeId(Long wetubeId) {
    this.wetubeId = wetubeId;
  }
  
  @Generated
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  
  @Generated
  public Long getCommentId() {
    return this.commentId;
  }
  
  @Generated
  public Long getCommentLikes() {
    return this.commentLikes;
  }
  
  @Generated
  public String getBody() {
    return this.body;
  }
  
  @Generated
  public String getNickName() {
    return this.nickName;
  }
  
  @Generated
  public String getProfileImage() {
    return this.profileImage;
  }
  
  @Generated
  public Wetube getWetube() {
    return this.wetube;
  }
  
  @Generated
  public Long getWetubeId() {
    return this.wetubeId;
  }
  
  @Generated
  public Long getUserId() {
    return this.userId;
  }
  
  public AddCommentRequest(WetubeComment comment) {
    this.commentId = comment.getCommentId();
    this.commentLikes = comment.getCommentLikes();
    this.body = comment.getBody();
    this.nickName = comment.getNickName();
    this.profileImage = comment.getProfileImage();
    this.wetube = comment.getWetube();
    this.wetubeId = comment.getWetube().getId();
    this.userId = comment.getWetube().getUser().getId();
  }
}
