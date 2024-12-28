package com.archive.test.dto;


import lombok.Generated;

public class WetubeLikeRequest {
  private Long id;
  
  private boolean isLiked;
  
  @Generated
  public Long getId() {
    return this.id;
  }
  
  @Generated
  public boolean isLiked() {
    return this.isLiked;
  }
  
  @Generated
  public void setId(Long id) {
    this.id = id;
  }
  
  @Generated
  public void setLiked(boolean isLiked) {
    this.isLiked = isLiked;
  }
}
