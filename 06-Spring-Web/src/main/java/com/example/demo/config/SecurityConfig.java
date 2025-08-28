//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/public/**").permitAll()
////                        .requestMatchers("/h2-console/**").permitAll()
////                        .anyRequest().authenticated()
////                )
//                .oauth2Login(Customizer.withDefaults()) // for user login
//                .oauth2ResourceServer(resource -> resource.jwt(Customizer.withDefaults()))
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**","/api/public/**","/oauth2/**"))
//                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)); // for H2 console
//
//        return http.build();
//
//    }
//}
//
