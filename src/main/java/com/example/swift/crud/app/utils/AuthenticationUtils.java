package com.example.swift.crud.app.utils;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class AuthenticationUtils {

    private static final String AUTH_TOKEN_PREFIX = "Bearer ";

    private static final String ROLE_PREFIX = "ROLE_";
    private static final String AUTHORITY_KEY = "authority";

    public static Optional<String> getAuthToken(HttpServletRequest request) {
        final String requestTokenHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (requestTokenHeader != null && requestTokenHeader.startsWith(AUTH_TOKEN_PREFIX)) {
            return Optional.of(requestTokenHeader.substring(AUTH_TOKEN_PREFIX.length()));
        }
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public static void setAuthenticationContext(HttpServletRequest request, Claims claims) {
        List<LinkedHashMap> authorities = (ArrayList<LinkedHashMap>) claims.get(JwtUtils.AUTHORITIES_CLAIM);
        List<String> roles = authorities
                .stream()
                .map(authority -> (String) authority.get(AUTHORITY_KEY))
                .map(role -> role.replace(ROLE_PREFIX, ""))
                .toList();
        UserDetails userDetails = User.withUsername(claims.get(JwtUtils.USERNAME_CLAIM, String.class))
                .password("") // leave empty
                .roles(roles.toArray(new String[0]))
                .build();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
