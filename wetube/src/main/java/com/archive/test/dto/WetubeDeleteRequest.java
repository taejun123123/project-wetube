package com.archive.test.dto;


import com.archive.test.entity.Wetube;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WetubeDeleteRequest {
  private Long id;
  
  public WetubeDeleteRequest(Wetube wetube) {
    this.id = wetube.getId();
  }
}
