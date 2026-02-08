package com.profitai.domain.auth.repository;

import com.profitai.domain.auth.entity.User;
import com.profitai.domain.auth.valueobject.Email;
import java.util.Optional;

public interface UserRepository {
	Optional<User> findByEmail(Email email);
	Optional<User> findById(String id);
	User save(User user);
	boolean existsByEmail(Email email);
}
