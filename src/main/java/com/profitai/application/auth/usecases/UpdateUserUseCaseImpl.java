package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.UpdateNameRequest;
import com.profitai.application.auth.dto.UserProfileResponse;
import com.profitai.application.auth.mapper.UserMapper;
import com.profitai.domain.auth.entity.User;
import com.profitai.domain.auth.repository.UserRepository;

/**
 * ImplementaÃ§Ã£o do caso de uso para atualizar dados do usuÃ¡rio.
 */
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

	private final UserRepository userRepository;

	public UpdateUserUseCaseImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserProfileResponse execute(User user, UpdateNameRequest request) {
		user.updateName(request.name());
		User updatedUser = userRepository.save(user);
		return UserMapper.toUserProfileResponse(updatedUser);
	}
}
