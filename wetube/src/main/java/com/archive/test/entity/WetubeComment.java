package com.archive.test.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WetubeComment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long commentId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "wetube_id")
  private Wetube wetube;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  @Column(nullable = false)
  private String nickName;

  @Column(nullable = false)
  private String body;

  @Column(nullable = false)
  private Long commentLikes = 0L;

  @Column
  private String profileImage;

  @Builder
  public WetubeComment(Long commentId, Wetube wetube, User user, String nickName, String body, String profileImage) {
    this.commentId = commentId;
    this.wetube = wetube;
    this.user = user;
    this.nickName = nickName;
    this.body = body;
    this.profileImage = profileImage;
  }

  // Update 메서드가 필요한 경우 추가 가능
  public void update(String body, String profileImage, Long commentLikes) {
    this.body = body;
    this.profileImage = profileImage;
    this.commentLikes = commentLikes;
  }
}
