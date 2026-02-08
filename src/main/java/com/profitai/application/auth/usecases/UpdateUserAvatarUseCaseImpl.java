package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.UpdateAvatarRequest;
import com.profitai.application.auth.dto.UserProfileResponse;
import com.profitai.application.auth.mapper.UserMapper;
import com.profitai.domain.auth.entity.User;
import com.profitai.domain.auth.repository.UserRepository;

public class UpdateUserAvatarUseCaseImpl implements UpdateUserAvatarUseCase {

	private final UserRepository userRepository;

	public UpdateUserAvatarUseCaseImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserProfileResponse execute(User user, UpdateAvatarRequest request) {
		user.updateAvatarKey(request.avatarKey());
		User updatedUser = userRepository.save(user);
		return UserMapper.toUserProfileResponse(updatedUser);
	}
}
