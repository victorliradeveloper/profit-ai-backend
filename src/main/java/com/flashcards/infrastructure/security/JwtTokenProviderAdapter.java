package com.flashcards.infrastructure.security;

import com.flashcards.domain.entity.User;
import com.flashcards.domain.port.TokenProvider;
import org.springframework.stereotype.Component;

/**
 * Adaptador que implementa a interface TokenProvider do domínio
 * usando a implementação JWT da infraestrutura.
 */
@Component
public class JwtTokenProviderAdapter implements TokenProvider {
    
    private final JwtTokenProvider jwtTokenProvider;
    
    public JwtTokenProviderAdapter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    
    @Override
    public String generateToken(User user) {
        return jwtTokenProvider.generateToken(user);
    }
    
    @Override
    public String validateToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }
    
    @Override
    public String getUserIdFromToken(String token) {
        return jwtTokenProvider.getUserIdFromToken(token);
    }
}

