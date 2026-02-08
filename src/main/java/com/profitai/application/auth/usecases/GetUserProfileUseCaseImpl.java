package com.profitai.application.auth.usecases;

import com.profitai.application.auth.dto.UserProfileResponse;
import com.profitai.application.auth.mapper.UserMapper;
import com.profitai.domain.auth.entity.User;

/**
 * ImplementaÃ§Ã£o do caso de uso para obter perfil do usuÃ¡rio.
 */
public class GetUserProfileUseCaseImpl implements GetUserProfileUseCase {
    
    @Override
    public UserProfileResponse execute(User user) {
        return UserMapper.toUserProfileResponse(user);
    }
}

