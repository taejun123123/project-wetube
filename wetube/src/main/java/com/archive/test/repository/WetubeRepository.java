package com.archive.test.repository;


import com.archive.test.entity.Wetube;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WetubeRepository extends JpaRepository<Wetube, Long> {
  List<Wetube> findByTitleContainingIgnoreCase(String paramString);
  
  @Query("SELECT w FROM Wetube w ORDER BY w.id DESC")
  List<Wetube> findByUserId(Long paramLong);
  
  @Query("SELECT w FROM Wetube w ORDER BY w.hit DESC")
  List<Wetube> findByUserIdHit(Long paramLong);
  
  Optional<Wetube> findFirstByUser_Id(Long paramLong);
}
