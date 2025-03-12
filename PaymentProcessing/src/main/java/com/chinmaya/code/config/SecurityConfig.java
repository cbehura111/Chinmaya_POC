package com.chinmaya.code.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // CSRF configuration
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers("/swagger-ui/**", "/v3/api-docs/**","/public/**") // Ignore CSRF for Swagger
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // CSRF token in cookies
//                        .ignoringRequestMatchers(HttpMethod.GET::equals) // Disable CSRF for GET requests
//                )
//                // Authorization configuration
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**","/public/**").permitAll() // Allow Swagger access
//                        .anyRequest().authenticated() // Protect other endpoints
//                );
//
//        return http.build();
//    }
}


