package com.flashcards.application.auth.usecases;

import com.flashcards.application.auth.dto.RegisterRequest;
import com.flashcards.application.auth.dto.LoginResponse;
import com.flashcards.application.auth.mapper.UserMapper;
import com.flashcards.domain.auth.entity.User;
import com.flashcards.domain.auth.exception.UserAlreadyExistsException;
import com.flashcards.domain.auth.repository.UserRepository;
import com.flashcards.domain.auth.port.PasswordEncoder;
import com.flashcards.domain.auth.port.TokenProvider;
import com.flashcards.domain.auth.valueobject.Email;
import com.flashcards.domain.auth.valueobject.Password;

/**
 * Implementação do caso de uso de registro de usuário.
 * Esta classe não usa frameworks, apenas lógica de negócio.
 */
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    
    public RegisterUserUseCaseImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            TokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }
    
    @Override
    public LoginResponse execute(RegisterRequest request) {
        Email email = Email.of(request.email());
        
        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("User already exists with email: " + request.email());
        }
        
        Password password = Password.fromPlainText(request.password(), passwordEncoder);
        User user = User.create(request.name(), email, password);
        
        User savedUser = userRepository.save(user);
        
        String token = tokenProvider.generateToken(savedUser);
        
        return UserMapper.toLoginResponse(savedUser, token);
    }
}

