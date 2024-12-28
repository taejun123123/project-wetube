package com.archive.test.repository;

import com.archive.test.entity.RefreshToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByUserId(Long paramLong);
  
  Optional<RefreshToken> findByRefreshToken(String paramString);
}
