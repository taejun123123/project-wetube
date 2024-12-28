package com.archive.test.controller;


import com.archive.test.dto.CreateAccessTokenRequest;
import com.archive.test.dto.CreateAccessTokenResponse;
import com.archive.test.service.TokenService;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenApiController {
  private final TokenService tokenService;
  
  @Generated
  public TokenApiController(TokenService tokenService) {
    this.tokenService = tokenService;
  }
  
  @PostMapping({"/api/token"})
  public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenRequest request) {
    String newAccessToken = this.tokenService.createNewAccessToken(request.getRefreshToken());
    return ResponseEntity.status((HttpStatusCode)HttpStatus.CREATED)
      .body(new CreateAccessTokenResponse(newAccessToken));
  }
}
