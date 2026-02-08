package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.LoginRequest;
import com.profitai.application.auth.dto.LoginResponse;

/**
 * Interface do caso de uso de login. Define o contrato para autenticaÃ§Ã£o de
 * usuÃ¡rios.
 */
public interface LoginUseCase {
	/**
	 * Executa o caso de uso de login.
	 * 
	 * @param request
	 *            dados de login (email e senha)
	 * @return resposta com token JWT e informaÃ§Ãµes do usuÃ¡rio
	 */
	LoginResponse execute(LoginRequest request);
}
