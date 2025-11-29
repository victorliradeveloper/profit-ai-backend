package com.flashcards.domain.auth.port;

import com.flashcards.domain.auth.entity.User;

/**
 * Porta (interface) para geração e validação de tokens JWT no domínio.
 * Implementações devem ser fornecidas pela camada de infraestrutura.
 * 
 * Esta é uma porta outbound (outbound port) que permite ao domínio
 * usar serviços de infraestrutura sem depender diretamente deles.
 */
public interface TokenProvider {
    /**
     * Gera um token JWT para o usuário.
     * 
     * @param user usuário para o qual o token será gerado
     * @return token JWT como string
     */
    String generateToken(User user);
    
    /**
     * Valida um token JWT e retorna o email do usuário.
     * 
     * @param token token JWT a ser validado
     * @return email do usuário se o token for válido, null caso contrário
     */
    String validateToken(String token);
    
    /**
     * Extrai o ID do usuário de um token JWT.
     * 
     * @param token token JWT
     * @return ID do usuário se o token for válido, null caso contrário
     */
    String getUserIdFromToken(String token);
}

