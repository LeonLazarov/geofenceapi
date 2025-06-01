package com.example.geofencingapi.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApiKeyAuthenticationToken extends AbstractAuthenticationToken {

    private final String apiKey;
    private final String apiSecret;

    public ApiKeyAuthenticationToken(String apiKey, String apiSecret) {
        super(null);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        setAuthenticated(false);
    }

    public ApiKeyAuthenticationToken(String apiKey, String apiSecret, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return apiSecret;
    }

    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
