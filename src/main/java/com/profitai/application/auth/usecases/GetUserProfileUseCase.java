package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.UserProfileResponse;
import com.profitai.domain.auth.entity.User;

/**
 * Interface do caso de uso para obter perfil do usuÃ¡rio autenticado.
 */
public interface GetUserProfileUseCase {
	/**
	 * ObtÃ©m o perfil do usuÃ¡rio autenticado.
	 * 
	 * @param user
	 *            usuÃ¡rio autenticado
	 * @return dados do perfil do usuÃ¡rio
	 */
	UserProfileResponse execute(User user);
}
