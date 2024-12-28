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
  public String save(MultipartFile image) throws IOException {
    String fileName = getOriginName(image);
    Path fullPath = Paths.get("C:\\study\\wetube\\src\\main\\resources\\static\\video", new String[] { fileName });
    Files.createDirectories(fullPath.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
    image.transferTo(fullPath.toFile());
    log.info("File saved at: {}", fullPath.toString());
    return fullPath.toString();
  }
  public String saveImage(MultipartFile image) throws IOException {
	  String fileName = getOriginName(image);
	  Path fullPath = Paths.get("C:\\study\\wetube\\src\\main\\resources\\static\\upload", new String[] { fileName });
	  Files.createDirectories(fullPath.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
	  image.transferTo(fullPath.toFile());
	  log.info("File saved at: {}", fullPath.toString());
	  return fullPath.toString();
  }
  
  private String getOriginName(MultipartFile image) {
    return image.getOriginalFilename();
  }
  
  public boolean deleteFile(String oldFile) {
    String fileName = oldFile.replace("/video/", "");
    Path filePath = Paths.get("C:\\study\\wetube\\src\\main\\resources\\static\\video", new String[] { fileName });
    try {
      if (Files.exists(filePath, new java.nio.file.LinkOption[0])) {
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
