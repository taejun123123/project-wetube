package com.archive.test.service;


import com.archive.test.config.jwt.TokenProvider;
import com.archive.test.entity.User;
import com.archive.test.service.RefreshTokenService;
import com.archive.test.service.UserService;
import java.time.Duration;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
  private final TokenProvider tokenProvider;
  
  private final RefreshTokenService refreshTokenService;
  
  private final UserService userService;
  
  @Generated
  public TokenService(TokenProvider tokenProvider, RefreshTokenService refreshTokenService, UserService userService) {
    this.tokenProvider = tokenProvider;
    this.refreshTokenService = refreshTokenService;
    this.userService = userService;
  }
  
  public String createNewAccessToken(String refreshToken) {
    if (!this.tokenProvider.validToken(refreshToken))
      throw new IllegalArgumentException("Unexpected token"); 
    Long userId = this.refreshTokenService.findByRefreshToken(refreshToken).getUserId();
    User user = this.userService.findById(userId);
    return this.tokenProvider.generateToken(user, Duration.ofHours(2L));
  }
}
