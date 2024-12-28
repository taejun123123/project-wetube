package com.archive.test.service;

import com.archive.test.dto.AddCommentRequest;
import com.archive.test.entity.Wetube;
import com.archive.test.entity.WetubeComment;
import com.archive.test.repository.WetubeCommentRepository;
import com.archive.test.repository.WetubeRepository;
import java.util.List;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
public class WetubeCommentService {
  
  private final WetubeCommentRepository commentRepository;
  private final WetubeRepository repository;

  @Generated
  public WetubeCommentService(WetubeCommentRepository commentRepository, WetubeRepository repository) {
    this.commentRepository = commentRepository;
    this.repository = repository;
  }

  public WetubeComment createComment(AddCommentRequest request, Long id) {
    Wetube wetube = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Wetube not found"));
    return commentRepository.save(WetubeComment.builder()
        .body(request.getBody())
        .nickName(request.getNickName())
        .profileImage(request.getProfileImage())
        .wetube(wetube)
        .build());
  }

  public List<WetubeComment> getComments(Long wetubeId) {
    return commentRepository.findByWetubeId(wetubeId);
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
