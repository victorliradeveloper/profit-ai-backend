package com.flashcards.application.auth.usecases;

import com.flashcards.application.auth.dto.LoginRequest;
import com.flashcards.application.auth.dto.LoginResponse;

/**
 * Interface do caso de uso de login.
 * Define o contrato para autenticação de usuários.
 */
public interface LoginUseCase {
    /**
     * Executa o caso de uso de login.
     * 
     * @param request dados de login (email e senha)
     * @return resposta com token JWT e informações do usuário
     */
    LoginResponse execute(LoginRequest request);
}

