package com.example.geofencingapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiKeyAuthProvider implements AuthenticationProvider {

    @Value("${api.key}")
    private String expectedApiKey;

    @Value("${api.secret}")
    private String expectedApiSecret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String apiKey = authentication.getPrincipal().toString();
        String apiSecret = authentication.getCredentials().toString();

        if (expectedApiKey.equals(apiKey) && expectedApiSecret.equals(apiSecret)) {
            return new ApiKeyAuthenticationToken(apiKey, apiSecret, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
