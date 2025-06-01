package com.example.geofencingapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String apiKey = request.getHeader("X-API-Key");
        String apiSecret = request.getHeader("X-API-Secret");

        if (apiKey == null || apiSecret == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing API key or secret");
            return;
        }

        Authentication authentication = new ApiKeyAuthenticationToken(apiKey, apiSecret);
        Authentication authenticated = authenticationManager.authenticate(authentication);

        if (authenticated == null || !authenticated.isAuthenticated()) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid API credentials");
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authenticated);
        filterChain.doFilter(request, response);
    }
}
