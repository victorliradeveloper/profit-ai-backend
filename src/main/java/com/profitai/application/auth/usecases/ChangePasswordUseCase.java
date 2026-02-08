package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.ChangePasswordRequest;
import com.profitai.domain.auth.entity.User;

/**
 * Interface do caso de uso para alterar senha do usuÃ¡rio.
 */
public interface ChangePasswordUseCase {
    /**
     * Altera a senha do usuÃ¡rio autenticado.
     * 
     * @param user usuÃ¡rio autenticado
     * @param request dados de alteraÃ§Ã£o de senha
     */
    void execute(User user, ChangePasswordRequest request);
}

