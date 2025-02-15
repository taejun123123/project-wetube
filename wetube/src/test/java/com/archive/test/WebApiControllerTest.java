package com.archive.test;

import com.archive.test.controller.WebApiController;
import com.archive.test.dto.WetubeDeleteRequest;
import com.archive.test.entity.Wetube;
import com.archive.test.service.WetubeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WebApiControllerTest {

    @InjectMocks
    private WebApiController webApiController;

    @Mock
    private WetubeService wetubeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("영상 생성 완료")
    void createVideo_ShouldReturnOkResponse() throws IOException {
        // Arrange
        MockMultipartFile mockFile = new MockMultipartFile("video", "test.mp4", MediaType.MULTIPART_FORM_DATA_VALUE, "Test Video".getBytes());
        String title = "Test Title";
        String content = "Test Content";
        Long userId = 1L;

        // Service 메소드가 boolean 값을 반환하도록 설정
        when(wetubeService.saveVideo(mockFile, title, content, userId)).thenReturn(true);

        // Act
        ResponseEntity<String> response = webApiController.createVideo(title, content, userId, mockFile);

        // Assert
        assertEquals("완료", response.getBody());  // 성공적인 응답 확인
        verify(wetubeService, times(1)).saveVideo(mockFile, title, content, userId);  // 메소드 호출 확인
    }

    @Test
    @DisplayName("영상 삭제 완료")
    void deleteVideo_ShouldReturnOkResponse() {
        // Arrange
        WetubeDeleteRequest request = new WetubeDeleteRequest();
        request.setId(1L);

        // Service 메소드가 제대로 실행되도록 설정
        doNothing().when(wetubeService).delete(request.getId());

        // Act
        ResponseEntity<String> response = webApiController.deleteVideo(request);

        // Assert
        assertEquals("완료", response.getBody());  // 성공적인 응답 확인
        verify(wetubeService, times(1)).delete(request.getId());  // 메소드 호출 확인
    }

    @Test
    @DisplayName("영상 수정 완료")
    void updateVideo_ShouldReturnOkResponse() throws IOException {
        // Arrange
        MockMultipartFile mockFile = new MockMultipartFile("video", "test.mp4", MediaType.MULTIPART_FORM_DATA_VALUE, "Test Video".getBytes());
        String title = "Updated Title";
        String content = "Updated Content";
        String oldFile = "oldFile.mp4";  // 이전 파일 이름
        Long userId = 1L;

        // Wetube 객체를 빌더를 사용하여 생성
        Wetube updatedVideo = Wetube.builder()
            .id(1L)
            .title("Original Title")
            .content("Original Content")
            .savedPath("originalPath")
            .build();

        // Service 메소드가 Wetube 객체를 반환하도록 설정
        when(wetubeService.update(userId, title, content, mockFile, oldFile)).thenReturn(updatedVideo);

        // Act
        ResponseEntity<String> response = webApiController.updateVideo(title, content, oldFile, userId, mockFile);

        // Assert
        assertEquals("완료", response.getBody());  // 성공적인 응답 확인
        verify(wetubeService, times(1)).update(userId, title, content, mockFile, oldFile);  // 메소드 호출 확인
    }
}
