package com.archive.test.controller;


import com.archive.test.dto.AddUserRequest;
import com.archive.test.dto.ResDTO;
import com.archive.test.service.UserService;
import java.io.IOException;
import java.util.Map;
import lombok.Generated;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserApiController {
  private final UserService userService;
  
  @Generated
  public UserApiController(UserService userService) {
    this.userService = userService;
  }
  
  @PostMapping({"/user"})
  public String signup(AddUserRequest request, @RequestParam("profile") MultipartFile files) throws IOException {
    this.userService.save(request, files);
    return "redirect:/login";
  }
  
  @PostMapping({"/login"})
  public HttpEntity<?> login(@RequestBody AddUserRequest request, Errors error) throws BadRequestException {
    if (error.hasErrors())
      throw new BadRequestException(((ObjectError)error.getAllErrors().get(0)).getDefaultMessage()); 
    return this.userService.login(request);
  }
  
  @PostMapping({"/check-token"})
  public ResponseEntity<?> checkToken(@RequestHeader(value = "Authorization", required = false) String accessToken, @RequestBody Map<String, String> body) throws BadRequestException {
    String refreshToken = body.get("refreshToken");
    ResDTO response = this.userService.checkTokens(accessToken, refreshToken);
    if (response.getCode().intValue() == 0)
      return ResponseEntity.ok(response); 
    return ResponseEntity.status((HttpStatusCode)HttpStatus.UNAUTHORIZED).body(response);
  }
}
