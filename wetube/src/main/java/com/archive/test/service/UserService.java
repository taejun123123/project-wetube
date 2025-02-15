package com.archive.test.service;
import com.archive.test.config.jwt.TokenProvider;
import com.archive.test.dto.AddUserRequest;
import com.archive.test.dto.ResDTO;
import com.archive.test.dto.hendler.ImageHandler;
import com.archive.test.entity.User;
import com.archive.test.repository.UserRepository;
import com.archive.test.service.JwtToken;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.time.Duration;
import lombok.Generated;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
  private final UserRepository userRepository;
  
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  
  private final TokenProvider provider;
  
  private final ImageHandler imageHandler;
  
  @Generated
  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TokenProvider provider, ImageHandler imageHandler) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.provider = provider;
    this.imageHandler = imageHandler;
  }
  
public Long save(AddUserRequest dto, MultipartFile files) throws IOException {
    String webPath = imageHandler.saveImage(files);  // 웹 경로 받기
    if (this.userRepository.existsByEmail(dto.getEmail())) 
        throw new IllegalArgumentException("이메일이 중복 되고 있습니다.");
    if (this.userRepository.existsByNickname(dto.getNickname())) 
        throw new IllegalArgumentException("닉네임이 중복되고 있습니다.");
    
    return this.userRepository.save(User.builder()
        .email(dto.getEmail())
        .nickname(dto.getNickname())
        .profile(webPath)  // DB에 저장된 경로
        .password(this.bCryptPasswordEncoder.encode(dto.getPassword()))
        .build()).getId();
}

  
  public User findById(Long userId) {
    return (User)this.userRepository.findById(userId)
      .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
  }
  
  public User findByEmail(String email) {
    return (User)this.userRepository.findByEmail(email)
      .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
  }
  
  public User authenticate(String email, String password) {
    User user = (User)this.userRepository.findByEmail(email)
      .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
    if (!this.bCryptPasswordEncoder.matches(password, user.getPassword()))
      throw new IllegalArgumentException("Invalid credentials"); 
    return user;
  }
  
  @Transactional
  public HttpEntity<?> login(AddUserRequest request) throws BadRequestException {
    User userEntity = (User)this.userRepository.findByEmail(request.getEmail())
      .orElseThrow(() -> new BadRequestException(""));
    if (!this.bCryptPasswordEncoder.matches(request.getPassword(), userEntity.getPassword()))
      throw new BadRequestException(); 
    String accessToken = this.provider.generateToken(userEntity, Duration.ofHours(1L));
    String refreshToken = this.provider.generateToken(userEntity, Duration.ofDays(7L));
    return (HttpEntity<?>)new ResponseEntity(
        ResDTO.builder()
        .code(Integer.valueOf(0))
        .message("")
        .data(JwtToken.builder()
          .accessToken(accessToken)
          .refreshToken(refreshToken)
          .build())
        .build(), 
        (HttpStatusCode)HttpStatus.OK);
  }
  
  public ResDTO checkTokens(String accessToken, String refreshToken) throws BadRequestException {
    if (accessToken != null && accessToken.startsWith("Bearer ")) {
      String token = accessToken.substring(7);
      if (this.provider.validToken(token) && !this.provider.isTokenExpired(token))
        return ResDTO.builder()
          .code(Integer.valueOf(0))
          .message("")
          .build(); 
    } 
    if (refreshToken != null && this.provider.validToken(refreshToken) && !this.provider.isTokenExpired(refreshToken)) {
      String email = this.provider.getUsernameFromToken(refreshToken);
      User userEntity = (User)this.userRepository.findByEmail(email)
        .orElseThrow(() -> new BadRequestException(""));
      String newAccessToken = this.provider.generateToken(userEntity, Duration.ofHours(1L));
      return ResDTO.builder()
        .code(Integer.valueOf(0))
        .message("")
        .data(JwtToken.builder()
          .accessToken(newAccessToken)
          .build())
        .build();
    } 
    return ResDTO.builder()
      .code(Integer.valueOf(1))
      .message("")
      .build();
  }
}
