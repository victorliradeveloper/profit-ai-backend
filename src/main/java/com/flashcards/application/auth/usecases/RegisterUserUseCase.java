package com.flashcards.application.auth.usecases;

import com.flashcards.application.auth.dto.RegisterRequest;
import com.flashcards.application.auth.dto.LoginResponse;

/**
 * Interface do caso de uso de registro de usuário.
 * Define o contrato para criação de novos usuários.
 */
public interface RegisterUserUseCase {
    /**
     * Executa o caso de uso de registro de usuário.
     * 
     * @param request dados de registro (nome, email e senha)
     * @return resposta com token JWT e informações do usuário criado
     */
    LoginResponse execute(RegisterRequest request);
}

