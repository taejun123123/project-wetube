package com.archive.test.dto;


import com.archive.test.entity.Wetube;
import com.archive.test.entity.WetubeComment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCommentRequest {
  private Long commentId;
  
  private Long commentLikes;
  
  private String body;
  
  private String nickName;
  
  private String profileImage;
  
  private Wetube wetube;
  
  private Long wetubeId;
  
  private Long userId;
  
  
  public AddCommentRequest(WetubeComment comment) {
    this.commentId = comment.getCommentId();
    this.commentLikes = comment.getCommentLikes();
    this.body = comment.getBody();
    this.nickName = comment.getNickName();
    this.profileImage = comment.getProfileImage();
    this.wetube = comment.getWetube();
    this.wetubeId = comment.getWetube().getId();
    this.userId = comment.getUser().getId();
  }
}
