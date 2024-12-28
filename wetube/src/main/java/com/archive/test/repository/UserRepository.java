package com.archive.test.repository;

import com.archive.test.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String paramString);
  
  boolean existsByEmail(String paramString);
  
  boolean existsByNickname(String paramString);
}
