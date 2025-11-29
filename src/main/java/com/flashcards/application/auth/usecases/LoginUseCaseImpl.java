package com.flashcards.application.auth.usecases;

import com.flashcards.application.auth.dto.LoginRequest;
import com.flashcards.application.auth.dto.LoginResponse;
import com.flashcards.application.auth.mapper.UserMapper;
import com.flashcards.domain.auth.entity.User;
import com.flashcards.domain.auth.exception.InvalidCredentialsException;
import com.flashcards.domain.auth.exception.UserNotFoundException;
import com.flashcards.domain.auth.repository.UserRepository;
import com.flashcards.domain.auth.port.PasswordEncoder;
import com.flashcards.domain.auth.port.TokenProvider;
import com.flashcards.domain.auth.valueobject.Email;

/**
 * Implementação do caso de uso de login.
 * Esta classe não usa frameworks, apenas lógica de negócio.
 */
public class LoginUseCaseImpl implements LoginUseCase {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    
    public LoginUseCaseImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            TokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }
    
    @Override
    public LoginResponse execute(LoginRequest request) {
        Email email = Email.of(request.email());
        
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + request.email()));
        
        if (!user.verifyPassword(request.password(), passwordEncoder)) {
            throw new InvalidCredentialsException("Invalid password");
        }
        
        String token = tokenProvider.generateToken(user);
        
        return UserMapper.toLoginResponse(user, token);
    }
}

