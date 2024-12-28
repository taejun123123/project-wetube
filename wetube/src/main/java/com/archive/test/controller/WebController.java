package com.archive.test.controller;


import com.archive.test.config.jwt.TokenProvider;
import com.archive.test.dto.UserResponse;
import com.archive.test.dto.WetubeLikeRequest;
import com.archive.test.dto.WetubeListSearchResponse;
import com.archive.test.dto.WetubeListViewResponse;
import com.archive.test.dto.WetubeResponse;
import com.archive.test.entity.User;
import com.archive.test.entity.Wetube;
import com.archive.test.service.UserService;
import com.archive.test.service.WetubeService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
  @Generated
  public WebController(WetubeService service, TokenProvider jwtTokenProvider, UserService userService) {
    this.service = service;
    this.jwtTokenProvider = jwtTokenProvider;
    this.userService = userService;
  }
  
  @Generated
  private static final Logger log = LogManager.getLogger(com.archive.test.controller.WebController.class);
  
  private final WetubeService service;
  
  private final TokenProvider jwtTokenProvider;
  
  private final UserService userService;
  
  @GetMapping({"/"})
  public String Main(Model model, HttpServletRequest request) {
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    List<WetubeListViewResponse> list = this.service.findAll().stream()
      .map(WetubeListViewResponse::new)
      .toList();
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("list", list);
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    return "main";
  }
  
  @GetMapping({"/watch"})
  public String watch(Model model, HttpServletRequest request, Long id) {
    Wetube search = this.service.findById(id.longValue());
    this.service.updateHit(id.longValue());
    List<WetubeListViewResponse> list = this.service.findAll().stream()
      .map(WetubeListViewResponse::new)
      .toList();
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    model.addAttribute("list", list);
    model.addAttribute("view", new WetubeResponse(search));
    return "watch";
  }
  
  @GetMapping({"/createVideo"})
  private String video(Model model, HttpServletRequest request) {
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    return "video";
  }
  
  @GetMapping({"/updateVideo"})
  private String video(Model model, Long id, HttpServletRequest request) {
    Wetube search = this.service.findById(id.longValue());
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    model.addAttribute("view", new WetubeResponse(search));
    return "videoUpdate";
  }
  
  @PostMapping({"/like"})
  public ResponseEntity<Integer> like(@RequestBody WetubeLikeRequest request) {
    Long id = request.getId();
    Wetube wetube = this.service.findById(id.longValue());
    int currentLikes = wetube.getLikes();
    wetube.setLikes(currentLikes + (request.isLiked() ? 1 : -1));
    this.service.save(wetube);
    return ResponseEntity.ok(Integer.valueOf(wetube.getLikes()));
  }
  
  @GetMapping({"/search"})
  public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model, HttpServletRequest request) {
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    List<WetubeListSearchResponse> results = (keyword != null) ? this.service.searchByTitle(keyword) : Collections.<WetubeListSearchResponse>emptyList();
    model.addAttribute("searchResults", results);
    return "search";
  }
  
  @GetMapping({"/channel"})
  public String channel(Model model, Long id, HttpServletRequest request) {
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    model.addAttribute("channelList", this.service.channelList(id));
    model.addAttribute("ListHit", this.service.channelListHit(id));
    model.addAttribute("channel", this.service.channel(id));
    return "channel";
  }
  
  @GetMapping({"/channel/videos"})
  public String videos(Model model, Long id, HttpServletRequest request) {
    boolean isValidToken = false;
    User email = null;
    String token = "";
    String accessToken = getCookieValue(request, "ACCESS-TOKEN");
    if (accessToken != null && this.jwtTokenProvider.validToken(accessToken)) {
      isValidToken = true;
      token = this.jwtTokenProvider.getEmailFromToken(accessToken);
      email = this.userService.findByEmail(token);
    } 
    if (token != null && token != "")
      model.addAttribute("user", new UserResponse(email)); 
    model.addAttribute("isValidToken", Boolean.valueOf(isValidToken));
    model.addAttribute("channelList", this.service.channelList(id));
    model.addAttribute("channel", this.service.channel(id));
    return "channelVideo";
  }
  
  private String getCookieValue(HttpServletRequest request, String cookieName) {
    if (request.getCookies() != null) {
      byte b;
      int i;
      Cookie[] arrayOfCookie;
      for (i = (arrayOfCookie = request.getCookies()).length, b = 0; b < i; ) {
        Cookie cookie = arrayOfCookie[b];
        if (cookie.getName().equals(cookieName))
          return cookie.getValue(); 
        b++;
      } 
    } 
    return null;
  }
}
