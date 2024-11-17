package com.example.swift.crud.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Beans {

    /* There are more secure ways to store tha password:
     * - store encrypted password in DB
     * - use external password manager like vault (for example Spring Cloud Vault)
     * - use identity provider */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("demo@swift.com")
                .password("$2a$10$28gWwD0hUcDq0Ss0oDAZJOGAPuNoRr4HdSivFa7Kc3.gV8dnGpyEC")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
