package com.archive.test.controller;


import com.archive.test.dto.AddCommentRequest;
import com.archive.test.dto.CommentResponse;
import com.archive.test.dto.LikeDislikeRequest;
import com.archive.test.entity.WetubeComment;
import com.archive.test.service.WetubeCommentService;
import java.util.List;
import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/comments"})
public class WetubeCommentController {
  @Generated
  public WetubeCommentController(WetubeCommentService commentService) {
    this.commentService = commentService;
  }
  
  @Generated
  private static final Logger log = LogManager.getLogger(com.archive.test.controller.WetubeCommentController.class);
  
  private final WetubeCommentService commentService;
  
  @PostMapping({"/create"})
  public WetubeComment createComment(@RequestBody AddCommentRequest request) {
    Long id = request.getWetubeId();
    return this.commentService.createComment(request, id);
  }
  
  @PostMapping({"/update-likes"})
  public ResponseEntity<?> updateLikes(@RequestBody LikeDislikeRequest request) {
    Long commentId = request.getCommentId();
    Long likeCount = request.getLikeCount();
    this.commentService.updateLikes(commentId, likeCount);
    return ResponseEntity.ok("");
  }
  
  @GetMapping({"/list"})
  public List<CommentResponse> getComments() {
      return commentService.getComments()
              .stream()
              .map(CommentResponse::new)
              .toList();
  }

  
  @PutMapping({"/update/{id}"})
  public WetubeComment updateComment(@PathVariable Long id, @RequestBody AddCommentRequest request) {
    return this.commentService.updateComment(id, request.getBody());
  }
  
  @DeleteMapping({"/delete/{id}"})
  public String deleteComment(@PathVariable Long id) {
    this.commentService.deleteComment(id);
    return "";
  }
}
