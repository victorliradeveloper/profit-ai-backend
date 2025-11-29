package com.flashcards.domain.auth.repository;

import com.flashcards.domain.auth.entity.User;
import com.flashcards.domain.auth.valueobject.Email;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(Email email);
    Optional<User> findById(String id);
    User save(User user);
    boolean existsByEmail(Email email);
}

