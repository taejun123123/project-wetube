package com.archive.test.entity;


import com.archive.test.entity.Wetube;
import com.archive.test.entity.WetubeComment;
import lombok.Generated;

@Generated
public class WetubeCommentBuilder {
  @Generated
  private Long commentId;
  
  @Generated
  private Wetube wetube;
  
  @Generated
  private String nickName;
  
  @Generated
  private String body;
  
  @Generated
  private String profileImage;
  
  @Generated
  public WetubeCommentBuilder commentId(Long commentId) {
    this.commentId = commentId;
    return this;
  }
  
  @Generated
  public WetubeCommentBuilder wetube(Wetube wetube) {
    this.wetube = wetube;
    return this;
  }
  
  @Generated
  public WetubeCommentBuilder nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }
  
  @Generated
  public WetubeCommentBuilder body(String body) {
    this.body = body;
    return this;
  }
  
  @Generated
  public WetubeCommentBuilder profileImage(String profileImage) {
    this.profileImage = profileImage;
    return this;
  }
  
  @Generated
  public WetubeComment build() {
    return new WetubeComment(this.commentId, this.wetube, this.nickName, this.body, this.profileImage);
  }
  
  @Generated
  public String toString() {
    return "WetubeComment.WetubeCommentBuilder(commentId=" + String.valueOf(this.commentId) + ", wetube=" + String.valueOf(this.wetube) + ", nickName=" + this.nickName + ", body=" + this.body + ", profileImage=" + this.profileImage + ")";
  }
}
