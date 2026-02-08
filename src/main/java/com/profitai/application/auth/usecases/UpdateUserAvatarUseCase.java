package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.UpdateAvatarRequest;
import com.profitai.application.auth.dto.UserProfileResponse;
import com.profitai.domain.auth.entity.User;

public interface UpdateUserAvatarUseCase {
	UserProfileResponse execute(User user, UpdateAvatarRequest request);
}
