package com.masai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.AdminSignupData;

public interface AdminSignupRepo extends JpaRepository<AdminSignupData, Integer> {

	
	
   public Optional<AdminSignupData> findByUserName(String username);
}
