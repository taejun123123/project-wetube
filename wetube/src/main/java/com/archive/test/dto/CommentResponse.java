package com.archive.test.dto;

import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import com.archive.test.entity.WetubeComment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentResponse {
	  private Long commentId;
	  
	  private Long commentLikes;
	  
	  private String body;
	  
	  private String nickName;
	  
	  private String profileImage;
	  
	  private Long wetubeId;
	  
	  private Long userId;
	  
	  public CommentResponse(WetubeComment comment) {
		    this.commentId = comment.getCommentId();
		    this.commentLikes = comment.getCommentLikes();
		    this.body = comment.getBody();
		    this.nickName = comment.getNickName();
		    this.profileImage = comment.getProfileImage();
		    this.wetubeId = comment.getWetube().getId();
		    this.userId = comment.getUser().getId();
	  }
}
