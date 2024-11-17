package com.example.swift.crud.app.config;

import com.example.swift.crud.app.utils.AuthenticationUtils;
import com.example.swift.crud.app.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> authTokenOptional = AuthenticationUtils.getAuthToken(request);
        if(authTokenOptional.isPresent()) {
            String token = authTokenOptional.get();
            Claims claims = jwtUtils.extractClaims(token);
            if(jwtUtils.isTokenExpired(token)) {
                throw new BadCredentialsException("Token expired");
            }

            AuthenticationUtils.setAuthenticationContext(request, claims);
        }
        filterChain.doFilter(request, response);
    }
}