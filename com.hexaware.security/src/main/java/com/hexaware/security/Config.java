package com.hexaware.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

    // Define the in-memory users
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("abc")
                .password("abc")
                .roles("ADMIN")
                .build();
        
        UserDetails user = User.withUsername("xyz")
                .password("xyz")
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(admin, user);
    }

    // Configure security for HTTP requests
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/AboutUS", "/ContacUs", "/SignIn", "/SignUp").permitAll() // Public pages
                .requestMatchers("/addProducts", "/removeProducts").hasRole("ADMIN") // Restricted to admin
                .anyRequest().authenticated()) // Any other requests require authentication
            .formLogin(); // Enables form login

        return http.build();
    }

    // Password encoder (NoOpPasswordEncoder for simplicity, replace with BCrypt for production)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
