package com.archive.test.entity;

import com.archive.test.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
public class Wetube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "savedPath", updatable = true)
    private String savedPath;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "likes")
    private int likes = 0;

    @Column(name = "hit", columnDefinition = "BIGINT DEFAULT 0")
    private Long hit =0L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    // @Builder 애노테이션을 사용하여 빌더 패턴을 자동으로 생성
    @Builder
    public Wetube(Long id, String savedPath, String title, String content, int likes, User user) {
        this.id = id;
        this.savedPath = savedPath;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.user = user;
    }

    // 기본 생성자
    protected Wetube() {}

    // update 메서드
    public void update(String title, String content, String savedPath) {
        this.title = title;
        this.content = content;
        this.savedPath = savedPath;
    }
}
