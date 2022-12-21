package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.AdminLoginDTO;
import com.masai.entity.AdminSignupData;
import com.masai.entity.CurrentUserSession;
import com.masai.exception.LogInException;
import com.masai.repo.AdminSignupRepo;
import com.masai.repo.CurrentUserSessionRepo;
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	@Autowired
	private AdminSignupRepo adminSignupRepo;

	@Override
	public CurrentUserSession loginAdmin(AdminLoginDTO adminLoginDTO) throws LogInException {
		
		Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUserName(adminLoginDTO.getUserName());
		
		if(userSession.isPresent()) {
			throw new LogInException("Admin has already logged in");
		}
		
		Optional<AdminSignupData> signupData=adminSignupRepo.findByUserName(adminLoginDTO.getUserName());
		
		if(signupData.isEmpty()) {
			
			throw new LogInException("No admin found with this username");
		}
		
		if(adminLoginDTO.getUserName().equals((signupData).get().getUserName()) && adminLoginDTO.getPassword().equals((signupData).get().getPassword())) {
			
			CurrentUserSession newUserSession= new CurrentUserSession();
			
			newUserSession.setUserName(adminLoginDTO.getUserName());
			newUserSession.setUuid(UUID.randomUUID().toString());
			newUserSession.setLocalDateTime(LocalDateTime.now());
			
			currentUserSessionRepo.save(newUserSession);
			
			return newUserSession;
	
		}
		else {
			throw new LogInException("Wrong credential");
		}
		
		
	}

	@Override
	public String logoutAdmin(String key) throws LogInException {
		Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUuid(key);
		
		if(userSession.isEmpty())
			throw new LogInException("Admin not logged in");
		
		currentUserSessionRepo.delete(userSession.get());
		
		return "Logged out....";
		
	}

}
