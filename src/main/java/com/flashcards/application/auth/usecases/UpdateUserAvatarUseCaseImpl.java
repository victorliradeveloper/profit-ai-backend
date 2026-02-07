package com.flashcards.application.auth.usecases;

import com.flashcards.application.auth.dto.UpdateAvatarRequest;
import com.flashcards.application.auth.dto.UserProfileResponse;
import com.flashcards.application.auth.mapper.UserMapper;
import com.flashcards.domain.auth.entity.User;
import com.flashcards.domain.auth.repository.UserRepository;

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

