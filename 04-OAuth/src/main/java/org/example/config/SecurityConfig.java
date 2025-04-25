package org.example.config;

import jakarta.servlet.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.*;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
            request.requestMatchers(antMatcher("/**/**/login")).permitAll();
        });
//        http.csrf((csrf) -> csrf
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//        );
        http.csrf(csrf -> {
            csrf.ignoringRequestMatchers("/**/**/login");
        });
        Filter authenticationTokenFilter = new BasicAuthenticationFilter( x -> x);
        http.addFilterBefore(authenticationTokenFilter, BasicAuthenticationFilter.class);
        AuthenticationProvider tokenAuthenticationProvider = new DaoAuthenticationProvider();
        http.authenticationProvider(tokenAuthenticationProvider);
        http.authorizeHttpRequests(request -> {
            request.anyRequest().authenticated();
        });
        return http.build();
    }
}
