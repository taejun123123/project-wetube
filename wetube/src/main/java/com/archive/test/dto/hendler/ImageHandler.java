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
  private static final String LOCAL_UPLOAD_PATH = "src/main/resources/static/upload";
  // 서버에서는 외부 경로로 설정
  private static final String SERVER_UPLOAD_PATH = "src/main/resources/static/upload"; // 서버 경로 수정

  // 로컬 환경과 서버 환경에 따른 경로 설정
  private String getUploadPath() {
    // 여기에서 환경 변수를 읽어와서 개발 환경과 서버 환경을 구분하도록 설정
    boolean isProduction = System.getenv("ENV") != null && System.getenv("ENV").equals("production");
    return isProduction ? SERVER_UPLOAD_PATH : LOCAL_UPLOAD_PATH;
  }

  public String save(MultipartFile image) throws IOException {
    String fileName = getOriginName(image);
    String uploadPath = getUploadPath();
    Path fullPath = Paths.get(uploadPath, fileName); // `static/upload` 경로 사용
    Files.createDirectories(fullPath.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
    image.transferTo(fullPath.toFile());
    log.info("File saved at: {}", fullPath.toString());
    return fullPath.toString();
  }

  public String saveImage(MultipartFile image) throws IOException {
    String fileName = getOriginName(image);
    String uploadPath = getUploadPath();
    Path fullPath = Paths.get(uploadPath, fileName); // `static/upload` 경로 사용
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
    String uploadPath = getUploadPath();
    Path filePath = Paths.get(uploadPath, fileName); // `static/upload` 경로 사용
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
