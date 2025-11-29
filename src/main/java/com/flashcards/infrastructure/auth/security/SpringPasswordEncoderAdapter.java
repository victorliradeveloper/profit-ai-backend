package com.flashcards.infrastructure.auth.security;

import com.flashcards.domain.auth.port.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Adaptador que implementa a interface PasswordEncoder do domínio
 * usando a implementação do Spring Security.
 */
@Component
public class SpringPasswordEncoderAdapter implements PasswordEncoder {
    
    private final org.springframework.security.crypto.password.PasswordEncoder springPasswordEncoder;
    
    public SpringPasswordEncoderAdapter(org.springframework.security.crypto.password.PasswordEncoder springPasswordEncoder) {
        this.springPasswordEncoder = springPasswordEncoder;
    }
    
    @Override
    public String encode(String plainPassword) {
        return springPasswordEncoder.encode(plainPassword);
    }
    
    @Override
    public boolean matches(String plainPassword, String hashedPassword) {
        return springPasswordEncoder.matches(plainPassword, hashedPassword);
    }
}

