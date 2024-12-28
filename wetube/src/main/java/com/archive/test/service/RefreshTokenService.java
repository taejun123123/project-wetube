package com.archive.test.service;

import com.archive.test.entity.RefreshToken;
import com.archive.test.repository.RefreshTokenRepository;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService {
  private final RefreshTokenRepository refreshTokenRepository;
  
  @Generated
  public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
    this.refreshTokenRepository = refreshTokenRepository;
  }
  
  public RefreshToken findByRefreshToken(String refreshToken) {
    return (RefreshToken)this.refreshTokenRepository.findByRefreshToken(refreshToken)
      .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
  }
}
