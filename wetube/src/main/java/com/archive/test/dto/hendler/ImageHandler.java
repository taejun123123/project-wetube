package com.archive.test.dto.hendler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageHandler {
  @Generated
  private static final Logger log = LogManager.getLogger(com.archive.test.dto.hendler.ImageHandler.class);

  // 로컬 개발 환경에서 테스트할 때
  private static final String LOCAL_UPLOAD_PATH = "C:\\study\\wetubeTest\\src\\main\\resources\\static\\upload";
  // 서버에서는 외부 경로로 설정
  private static final String SERVER_UPLOAD_PATH = "/var/www/uploads"; // 서버에 맞는 경로로 수정

  public String save(MultipartFile image) throws IOException {
    String fileName = getOriginName(image);
    Path fullPath = Paths.get(SERVER_UPLOAD_PATH, fileName); // 서버 경로 사용
    Files.createDirectories(fullPath.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
    image.transferTo(fullPath.toFile());
    log.info("File saved at: {}", fullPath.toString());
    return fullPath.toString();
  }

  public String saveImage(MultipartFile image) throws IOException {
    String fileName = getOriginName(image);
    Path fullPath = Paths.get(SERVER_UPLOAD_PATH, fileName); // 서버 경로 사용
    Files.createDirectories(fullPath.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
    image.transferTo(fullPath.toFile());
    log.info("File saved at: {}", fullPath.toString());
    return fullPath.toString();
  }

  private String getOriginName(MultipartFile image) {
    return image.getOriginalFilename();
  }

  public boolean deleteFile(String oldFile) {
    String fileName = oldFile.replace("/upload/", "");
    Path filePath = Paths.get(SERVER_UPLOAD_PATH, fileName); // 서버 경로 사용
    try {
      if (Files.exists(filePath)) {
        Files.delete(filePath);
        log.info("File deleted: {}", filePath.toString());
        return true;
      } 
      log.warn("File not found for deletion: {}", filePath.toString());
      return false;
    } catch (IOException e) {
      log.error("Failed to delete file: {}", filePath.toString(), e);
      return false;
    } 
  }
}
