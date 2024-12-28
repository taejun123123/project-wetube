package com.archive.test.repository;

import com.archive.test.entity.WetubeComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WetubeCommentRepository extends JpaRepository<WetubeComment, Long> {
  List<WetubeComment> findByWetubeId(Long paramLong);
}
