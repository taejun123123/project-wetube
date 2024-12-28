package com.archive.test.service;

import com.archive.test.dto.WetubeListSearchResponse;
import com.archive.test.dto.hendler.ImageHandler;
import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import com.archive.test.repository.UserRepository;
import com.archive.test.repository.WetubeRepository;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class WetubeService {

  @Generated
  public WetubeService(WetubeRepository repository, ImageHandler imageHandler, UserRepository userRepository) {
    this.repository = repository;
    this.imageHandler = imageHandler;
    this.userRepository = userRepository;
  }

  @Generated
  private static final Logger log = LogManager.getLogger(WetubeService.class);

  private final WetubeRepository repository;
  private final ImageHandler imageHandler;
  private final UserRepository userRepository;

  public List<Wetube> findAll() {
    return repository.findAll();
  }

  public Wetube findById(long id) {
    return repository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Wetube not found: " + id));
  }

  public boolean saveVideo(MultipartFile image, String title, String content, Long id) throws IOException {
    String fileName = image.getOriginalFilename();
    String filePath = imageHandler.save(image);
    String webPath = "/video/" + fileName;
    User user = userRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("User not found"));
    Wetube imageEntity = Wetube.builder()
      .savedPath(webPath)
      .content(content)
      .title(title)
      .user(user)
      .build();
    repository.save(imageEntity);
    return true;
  }

  @Transactional
  public Wetube updateHit(long id) {
    Wetube wetube = repository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    wetube.setHit(wetube.getHit() + 1);
    return wetube;
  }

  @Transactional
  public void save(Wetube wetube) {
    repository.save(wetube);
  }

  public List<WetubeListSearchResponse> searchByTitle(String keyword) {
    List<Wetube> wetubes = repository.findByTitleContainingIgnoreCase(keyword);
    return wetubes.stream()
      .map(WetubeListSearchResponse::new)
      .collect(Collectors.toList());
  }

  public List<WetubeListSearchResponse> channelList(Long id) {
    List<Wetube> wetubeList = repository.findByUserId(id);
    return wetubeList.stream()
      .map(WetubeListSearchResponse::new)
      .collect(Collectors.toList());
  }

  public List<WetubeListSearchResponse> channelListHit(Long id) {
    List<Wetube> wetubeList = repository.findByUserIdHit(id);
    return wetubeList.stream()
      .map(WetubeListSearchResponse::new)
      .collect(Collectors.toList());
  }

  public WetubeListSearchResponse channel(Long id) {
    Optional<Wetube> wetube = repository.findFirstByUser_Id(id);
    return wetube.map(WetubeListSearchResponse::new)
      .orElseThrow(() -> new IllegalArgumentException("Wetube not found for user ID: " + id));
  }

  @Transactional
  public Wetube update(Long id, String title, String content, MultipartFile video, String oldfile) throws IOException {
    imageHandler.deleteFile(oldfile);
    String fileName = video.getOriginalFilename();
    String filePath = imageHandler.save(video);
    String webPath = "/video/" + fileName;
    Wetube wetube = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("id not found"));
    wetube.update(title, content, webPath);
    return wetube;
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
