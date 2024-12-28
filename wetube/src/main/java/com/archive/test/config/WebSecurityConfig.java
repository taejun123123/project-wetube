package com.archive.test.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.archive.test.service.UserDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final UserDetailService userService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  // CSRF 비활성화 (JWT로 대체)
                .httpBasic(basic -> basic.disable())  // HTTP 기본 인증 비활성화
                .formLogin(form -> form.disable())  // 폼 로그인 비활성화
                		//테스트 해봐야 하기 때문에 모든 접근 허용 
                	     .authorizeHttpRequests(auth -> auth
                                 .anyRequest().permitAll()  // 모든 요청 허용
                         )
                	     //접근 설정할 떄 사용
               	     //.authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/login", "/signup", "/user", "/","/watch","/user").permitAll()  // 특정 경로 접근 허용
                        //.anyRequest().authenticated()  // 나머지는 인증 필요
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers("/upload/**","/css/**","/video/**"); // 정적 자원에 대해 보안 무시
    }

}