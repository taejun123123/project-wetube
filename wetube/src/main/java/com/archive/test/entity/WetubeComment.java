package com.archive.test.entity;

import com.archive.test.entity.Wetube;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Generated;

@Entity
public class WetubeComment {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wetubeComment_seq")
  @SequenceGenerator(name = "wetubeComment_seq", sequenceName = "WETUBECOMMENT_SEQ", allocationSize = 1)
  private Long commentId;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "wetube_Id")
  private Wetube wetube;
  
  @Column(nullable = false)
  private String nickName;
  
  @Column(nullable = false)
  private String body;
  
  @Generated
  public Long getCommentId() {
    return this.commentId;
  }
  
  @Generated
  public Wetube getWetube() {
    return this.wetube;
  }
  
  @Generated
  public String getNickName() {
    return this.nickName;
  }
  
  @Generated
  public String getBody() {
    return this.body;
  }
  
  @Generated
  public Long getCommentLikes() {
    return this.commentLikes;
  }
  
  @Generated
  public String getProfileImage() {
    return this.profileImage;
  }
  
  @Generated
  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }
  
  @Generated
  public void setWetube(Wetube wetube) {
    this.wetube = wetube;
  }
  
  @Generated
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  
  @Generated
  public void setBody(String body) {
    this.body = body;
  }
  
  @Generated
  public void setCommentLikes(Long commentLikes) {
    this.commentLikes = commentLikes;
  }
  
  @Generated
  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }
  
  @Column
  private Long commentLikes = Long.valueOf(0L);
  
  @Column
  private String profileImage;
  
  @Generated
  public static WetubeCommentBuilder builder() {
    return new WetubeCommentBuilder();
  }
  
  public WetubeComment(Long commentId, Wetube wetube, String nickName, String body, String profileImage) {
    this.commentId = commentId;
    this.wetube = wetube;
    this.nickName = nickName;
    this.body = body;
    this.profileImage = profileImage;
  }
  
  @Generated
  protected WetubeComment() {}
}
