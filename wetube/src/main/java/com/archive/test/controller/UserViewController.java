package com.archive.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
  @GetMapping({"/login"})
  public String login() {
    return "User/login";
  }
  
  @GetMapping({"/signup"})
  public String signup() {
    return "User/signup";
  }
}
