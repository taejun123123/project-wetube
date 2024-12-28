package com.archive.test.entity;


import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import lombok.Generated;

@Generated
public class WetubeBuilder {
  @Generated
  private Long id;
  
  @Generated
  private String savedPath;
  
  @Generated
  private String title;
  
  @Generated
  private String content;
  
  @Generated
  private User user;
  
  @Generated
  public WetubeBuilder id(Long id) {
    this.id = id;
    return this;
  }
  
  @Generated
  public WetubeBuilder savedPath(String savedPath) {
    this.savedPath = savedPath;
    return this;
  }
  
  @Generated
  public WetubeBuilder title(String title) {
    this.title = title;
    return this;
  }
  
  @Generated
  public WetubeBuilder content(String content) {
    this.content = content;
    return this;
  }
  
  @Generated
  public WetubeBuilder user(User user) {
    this.user = user;
    return this;
  }
  
  @Generated
  public Wetube build() {
    return new Wetube(this.id, this.savedPath, this.title, this.content, this.user);
  }
  
  @Generated
  public String toString() {
    return "Wetube.WetubeBuilder(id=" + String.valueOf(this.id) + ", savedPath=" + this.savedPath + ", title=" + this.title + ", content=" + this.content + ", user=" + String.valueOf(this.user) + ")";
  }
}
