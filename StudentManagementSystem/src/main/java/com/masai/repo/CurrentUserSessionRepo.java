package com.masai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.CurrentUserSession;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {

	Optional<CurrentUserSession> findByUserName(String username);
	
	Optional<CurrentUserSession> findByUuid(String uuid);
	
	
}
