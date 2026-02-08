package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.UpdateNameRequest;
import com.profitai.application.auth.dto.UserProfileResponse;
import com.profitai.domain.auth.entity.User;

/**
 * Interface do caso de uso para atualizar dados do usuÃ¡rio.
 */
public interface UpdateUserUseCase {
	/**
	 * Atualiza o nome do usuÃ¡rio autenticado.
	 * 
	 * @param user
	 *            usuÃ¡rio autenticado
	 * @param request
	 *            dados de atualizaÃ§Ã£o
	 * @return dados atualizados do usuÃ¡rio
	 */
	UserProfileResponse execute(User user, UpdateNameRequest request);
}
