package com.archive.test.dto;

import com.archive.test.entity.Wetube;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class WetubeDeleteRequest {
    private Long id;

    // Wetube 객체를 이용한 생성자
    public WetubeDeleteRequest(Wetube wetube) {
        this.id = wetube.getId();
    }

    // long 타입의 id를 직접 받는 생성자
    public WetubeDeleteRequest(Long id) {
        this.id = id;
    }
}