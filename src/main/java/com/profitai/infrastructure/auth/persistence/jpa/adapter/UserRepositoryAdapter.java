package com.profitai.infrastructure.auth.persistence.jpa.adapter;

import com.profitai.domain.auth.entity.User;
import com.profitai.domain.auth.repository.UserRepository;
import com.profitai.domain.auth.valueobject.Email;
import com.profitai.infrastructure.auth.persistence.jpa.entity.UserEntity;
import com.profitai.infrastructure.auth.persistence.jpa.mapper.UserEntityMapper;
import com.profitai.infrastructure.auth.persistence.jpa.repository.JpaUserRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * Adaptador que implementa o repositÃ³rio de domÃ­nio usando JPA. Converte
 * entre entidades de domÃ­nio e entidades JPA.
 */
@Component
public class UserRepositoryAdapter implements UserRepository {

	private final JpaUserRepository jpaUserRepository;
	private final UserEntityMapper mapper;

	public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
		this.jpaUserRepository = jpaUserRepository;
		this.mapper = new UserEntityMapper();
	}

	@Override
	public Optional<User> findByEmail(Email email) {
		return jpaUserRepository.findByEmail(email.getValue()).map(mapper::toDomain);
	}

	@Override
	public Optional<User> findById(String id) {
		return jpaUserRepository.findById(id).map(mapper::toDomain);
	}

	@Override
	public User save(User user) {
		UserEntity entity = mapper.toEntity(user);
		UserEntity savedEntity = jpaUserRepository.save(entity);
		return mapper.toDomain(savedEntity);
	}

	@Override
	public boolean existsByEmail(Email email) {
		return jpaUserRepository.existsByEmail(email.getValue());
	}
}
