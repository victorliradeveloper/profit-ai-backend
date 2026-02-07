package com.flashcards.application.auth.usecases;

import com.flashcards.application.auth.dto.UpdateAvatarRequest;
import com.flashcards.application.auth.dto.UserProfileResponse;
import com.flashcards.domain.auth.entity.User;

public interface UpdateUserAvatarUseCase {
    UserProfileResponse execute(User user, UpdateAvatarRequest request);
}

