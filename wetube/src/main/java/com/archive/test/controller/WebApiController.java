package com.archive.test.controller;


import com.archive.test.dto.WetubeDeleteRequest;
import com.archive.test.service.WetubeService;
import java.io.IOException;
import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/api/videos"})
public class WebApiController {
  @Generated
  public WebApiController(WetubeService service) {
    this.service = service;
  }
  
  @Generated
  private static final Logger log = LogManager.getLogger(com.archive.test.controller.WebApiController.class);
  
  private final WetubeService service;
  
  @PostMapping
  public ResponseEntity<String> createVideo(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("id") Long id, @RequestParam("video") MultipartFile video) throws IOException {
    this.service.saveVideo(video, title, content, id);
    return ResponseEntity.ok("완료");
  }
  
  @PutMapping
  public ResponseEntity<String> updateVideo(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("oldfile") String oldfile, @RequestParam("id") Long id, @RequestParam("video") MultipartFile video) throws IOException {
    this.service.update(id, title, content, video, oldfile);
    return ResponseEntity.ok("완료");
  }
  
  @DeleteMapping
  public ResponseEntity<String> deleteVideo(@RequestBody WetubeDeleteRequest request) {
    this.service.delete(request.getId().longValue());
    return ResponseEntity.ok("완료");
  }
}
