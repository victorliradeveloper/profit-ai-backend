package com.flashcards.infrastructure.auth.persistence.jpa.mapper;

import com.flashcards.domain.auth.entity.User;
import com.flashcards.domain.auth.valueobject.Email;
import com.flashcards.domain.auth.valueobject.Password;
import com.flashcards.infrastructure.auth.persistence.jpa.entity.UserEntity;

/**
 * Mapper responsável por converter entre entidades de domínio (User) 
 * e entidades de persistência (UserEntity).
 */
public class UserEntityMapper {
    
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail().getValue());
        entity.setPassword(user.getPassword().getHashedValue());
        entity.setAvatarKey(user.getAvatarKey());
        return entity;
    }
    
    public User toDomain(UserEntity entity) {
        Email email = Email.of(entity.getEmail());
        Password password = Password.fromHashed(entity.getPassword());
        return User.restore(entity.getId(), entity.getName(), email, password, entity.getAvatarKey());
    }
}

