package com.masai.service;

import com.masai.entity.AdminSignupData;
import com.masai.exception.SignUpException;

public interface AdminSignupService {
	
	public AdminSignupData createAdmin(AdminSignupData adminSignUpData)throws SignUpException;
	

}
