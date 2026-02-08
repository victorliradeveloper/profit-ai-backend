package com.profitai.infrastructure.auth.config;

import com.profitai.application.auth.usecases.ChangePasswordUseCase;
import com.profitai.application.auth.usecases.ChangePasswordUseCaseImpl;
import com.profitai.application.auth.usecases.GetUserProfileUseCase;
import com.profitai.application.auth.usecases.GetUserProfileUseCaseImpl;
import com.profitai.application.auth.usecases.LoginUseCase;
import com.profitai.application.auth.usecases.LoginUseCaseImpl;
import com.profitai.application.auth.usecases.RegisterUserUseCase;
import com.profitai.application.auth.usecases.RegisterUserUseCaseImpl;
import com.profitai.application.auth.usecases.UpdateUserUseCase;
import com.profitai.application.auth.usecases.UpdateUserUseCaseImpl;
import com.profitai.application.auth.usecases.UpdateUserAvatarUseCase;
import com.profitai.application.auth.usecases.UpdateUserAvatarUseCaseImpl;
import com.profitai.domain.auth.port.PasswordEncoder;
import com.profitai.domain.auth.port.TokenProvider;
import com.profitai.domain.auth.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConfiguraÃ§Ã£o para registrar os casos de uso de autenticaÃ§Ã£o no Spring.
 * Esta classe faz a ponte entre a camada de aplicaÃ§Ã£o (sem frameworks)
 * e a camada de infraestrutura (com Spring).
 */
@Configuration
public class AuthUseCaseConfig {
    
    @Bean
    public LoginUseCase loginUseCase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            TokenProvider tokenProvider) {
        return new LoginUseCaseImpl(userRepository, passwordEncoder, tokenProvider);
    }
    
    @Bean
    public RegisterUserUseCase registerUserUseCase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            TokenProvider tokenProvider) {
        return new RegisterUserUseCaseImpl(userRepository, passwordEncoder, tokenProvider);
    }
    
    @Bean
    public GetUserProfileUseCase getUserProfileUseCase() {
        return new GetUserProfileUseCaseImpl();
    }
    
    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository) {
        return new UpdateUserUseCaseImpl(userRepository);
    }

    @Bean
    public UpdateUserAvatarUseCase updateUserAvatarUseCase(UserRepository userRepository) {
        return new UpdateUserAvatarUseCaseImpl(userRepository);
    }
    
    @Bean
    public ChangePasswordUseCase changePasswordUseCase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        return new ChangePasswordUseCaseImpl(userRepository, passwordEncoder);
    }
}


