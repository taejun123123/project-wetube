package com.archive.test.dto;


import lombok.Generated;

public class LikeDislikeRequest {
  private Long commentId;
  
  private Long likeCount;
  
  @Generated
  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }
  
  @Generated
  public void setLikeCount(Long likeCount) {
    this.likeCount = likeCount;
  }
  
  @Generated
  public Long getCommentId() {
    return this.commentId;
  }
  
  @Generated
  public Long getLikeCount() {
    return this.likeCount;
  }
}
