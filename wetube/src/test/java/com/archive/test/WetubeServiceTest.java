package com.archive.test;

import com.archive.test.dto.hendler.ImageHandler;
import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import com.archive.test.repository.UserRepository;
import com.archive.test.repository.WetubeRepository;
import com.archive.test.service.WetubeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WetubeServiceTest {

    @InjectMocks
    private WetubeService wetubeService;

    @Mock
    private WetubeRepository wetubeRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ImageHandler imageHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveVideo_ShouldSaveVideoSuccessfully() throws IOException {
        // Arrange
        Long userId = 1L;
        String title = "Test Video";
        String content = "Test Content";
        MultipartFile mockFile = mock(MultipartFile.class);
        String filePath = "/video/test.mp4";

        // User 객체는 @Builder로 생성
        User mockUser = User.builder()
                            .id(userId)
                            .email("test@example.com")
                            .password("password123")
                            .profile("default_profile.png")
                            .nickname("testuser")
                            .build();

        // Mocking MultipartFile behavior
        when(mockFile.getOriginalFilename()).thenReturn("test.mp4");
        when(imageHandler.save(mockFile)).thenReturn(filePath);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Act
        boolean result = wetubeService.saveVideo(mockFile, title, content, userId);

        // Assert
        assertTrue(result);
        verify(wetubeRepository, times(1)).save(any(Wetube.class));  // Wetube 객체 저장 확인
    }

    @Test
    void saveVideo_ShouldThrowException_WhenUserNotFound() {
        // Arrange
        Long userId = 1L;
        String title = "Test Video";
        String content = "Test Content";
        MultipartFile mockFile = mock(MultipartFile.class);

        // Mocking User not found
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> wetubeService.saveVideo(mockFile, title, content, userId));
    }
}
