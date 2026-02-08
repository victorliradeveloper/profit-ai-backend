package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.LoginRequest;
import com.profitai.application.auth.dto.LoginResponse;
import com.profitai.application.auth.mapper.UserMapper;
import com.profitai.domain.auth.entity.User;
import com.profitai.domain.auth.exception.InvalidCredentialsException;
import com.profitai.domain.auth.exception.UserNotFoundException;
import com.profitai.domain.auth.repository.UserRepository;
import com.profitai.domain.auth.port.PasswordEncoder;
import com.profitai.domain.auth.port.TokenProvider;
import com.profitai.domain.auth.valueobject.Email;

/**
 * ImplementaÃ§Ã£o do caso de uso de login.
 * Esta classe nÃ£o usa frameworks, apenas lÃ³gica de negÃ³cio.
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


