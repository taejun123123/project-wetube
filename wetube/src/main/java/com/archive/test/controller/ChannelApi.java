package com.archive.test.controller;

import com.archive.test.dto.WetubeDeleteRequest;
import com.archive.test.service.WetubeService;
import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/channel"})
public class ChannelApi {
  @Generated
  public ChannelApi(WetubeService service) {
    this.service = service;
  }
  
  @Generated
  private static final Logger log = LogManager.getLogger(com.archive.test.controller.ChannelApi.class);
  
  private final WetubeService service;
  
  @PostMapping
  public ResponseEntity<String> channel(@RequestBody WetubeDeleteRequest request) {
    Long id = request.getId();
    return ResponseEntity.ok("완료");
  }
}
