package com.archive.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WetubeApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(com.archive.test.WetubeApplication.class, args);
  }
}
