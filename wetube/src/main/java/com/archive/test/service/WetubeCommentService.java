package com.archive.test.service;

import com.archive.test.dto.AddCommentRequest;
import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import com.archive.test.entity.WetubeComment;
import com.archive.test.repository.UserRepository;
import com.archive.test.repository.WetubeCommentRepository;
import com.archive.test.repository.WetubeRepository;
import java.util.List;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WetubeCommentService {
  
  private final WetubeCommentRepository commentRepository;
  private final WetubeRepository repository;
  private final UserRepository userRepository;


  public WetubeComment createComment(AddCommentRequest request, Long id) {
    Wetube wetube = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Wetube not found"));
    User user = userRepository.findById(request.getUserId())
    		 .orElseThrow(() -> new RuntimeException("user not found"));
    return commentRepository.save(WetubeComment.builder()
        .body(request.getBody())
        .nickName(request.getNickName())
        .profileImage(request.getProfileImage())
        .wetube(wetube)
        .user(user)
        .build());
  }
  public List<WetubeComment> getComments() {
      // id 값을 사용하여 특정 댓글만 조회
      return commentRepository.findAll();
  }

  public WetubeComment updateComment(Long id, String body) {
    WetubeComment comment = commentRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
    comment.setBody(body);
    return commentRepository.save(comment);
  }

  public WetubeComment updateLikes(Long commentId, Long likeCount) {
    WetubeComment comment = commentRepository.findById(commentId)
      .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
    comment.setCommentLikes(likeCount);
    commentRepository.save(comment);
    return comment;
  }

  public void deleteComment(Long id) {
    commentRepository.deleteById(id);
  }
}
