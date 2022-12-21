package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.AdminSignupData;
import com.masai.exception.SignUpException;
import com.masai.repo.AdminSignupRepo;
@Service
public class AdminSignUpServiceImpl implements AdminSignupService {
	
	@Autowired
	private AdminSignupRepo adminSignupRepo;
	

	@Override
	public AdminSignupData createAdmin(AdminSignupData adminSignUpData) throws SignUpException {
		
		
		Optional<AdminSignupData> signupData=adminSignupRepo.findByUserName(adminSignUpData.getUserName());
		
		if(signupData.isPresent()) {
			throw new SignUpException("Admin already present with this username");
		}
		
		AdminSignupData registeredSignUpdata=adminSignupRepo.save(adminSignUpData);
		
		return registeredSignUpdata;
	}

}
