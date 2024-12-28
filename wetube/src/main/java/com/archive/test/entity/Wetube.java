package com.archive.test.entity;

import com.archive.test.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
public class Wetube {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wetube_seq")
  @SequenceGenerator(name = "wetube_seq", sequenceName = "WETUBE_SEQ", allocationSize = 1)
  @Column(name = "id", updatable = false)
  private Long id;
  
  @Column(name = "savedPath", updatable = true)
  private String savedPath;
  
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  
  @LastModifiedDate
  @Column(name = "update_at")
  private LocalDateTime updateAt;
  
  @Column(name = "title", nullable = false)
  private String title;
  
  @Column(name = "content", nullable = false)
  private String content;
  
  @Generated
  public Long getId() {
    return this.id;
  }
  
  @Generated
  public String getSavedPath() {
    return this.savedPath;
  }
  
  @Generated
  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }
  
  @Generated
  public LocalDateTime getUpdateAt() {
    return this.updateAt;
  }
  
  @Generated
  public String getTitle() {
    return this.title;
  }
  
  @Generated
  public String getContent() {
    return this.content;
  }
  
  @Generated
  public int getLikes() {
    return this.likes;
  }
  
  @Generated
  public Long getHit() {
    return this.hit;
  }
  
  @Generated
  public User getUser() {
    return this.user;
  }
  
  @Generated
  public void setId(Long id) {
    this.id = id;
  }
  
  @Generated
  public void setSavedPath(String savedPath) {
    this.savedPath = savedPath;
  }
  
  @Generated
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  
  @Generated
  public void setUpdateAt(LocalDateTime updateAt) {
    this.updateAt = updateAt;
  }
  
  @Generated
  public void setTitle(String title) {
    this.title = title;
  }
  
  @Generated
  public void setContent(String content) {
    this.content = content;
  }
  
  @Generated
  public void setLikes(int likes) {
    this.likes = likes;
  }
  
  @Generated
  public void setHit(Long hit) {
    this.hit = hit;
  }
  
  @Generated
  public void setUser(User user) {
    this.user = user;
  }
  
  @Column(name = "likes")
  private int likes = 0;
  
  @Column
  private Long hit = Long.valueOf(0L);
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;
  
  @Generated
  public static WetubeBuilder builder() {
    return new WetubeBuilder();
  }
  
  public Wetube(Long id, String savedPath, String title, String content, User user) {
    this.id = id;
    this.savedPath = savedPath;
    this.title = title;
    this.content = content;
    this.user = user;
  }
  
  public void update(String title, String content, String savedPath) {
    this.title = title;
    this.content = content;
    this.savedPath = savedPath;
  }
  
  @Generated
  protected Wetube() {}
}
