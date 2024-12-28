package com.archive.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
  @GetMapping({"/error/noPermission"})
  public String noPermission() {
    return "error/noPermission";
  }
}