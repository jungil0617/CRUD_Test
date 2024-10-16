package com.example.TestCRUD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home", "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/home").permitAll()
                )
                .logout(logout -> logout.permitAll());

        // H2 콘솔을 사용하기 위한 설정 (프레임 옵션 비활성화)
        http.headers(headers ->
                headers.addHeaderWriter(new StaticHeadersWriter("X-Frame-Options", "SAMEORIGIN"))
        );

        // CSRF 비활성화 (개발용)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // 안전한 비밀번호 인코딩 방식 사용
    }
}
