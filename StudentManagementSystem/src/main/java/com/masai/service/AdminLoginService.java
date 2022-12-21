package com.masai.service;

import com.masai.dto.AdminLoginDTO;
import com.masai.entity.CurrentUserSession;
import com.masai.exception.LogInException;

public interface AdminLoginService {
	
	public CurrentUserSession loginAdmin(AdminLoginDTO adminLoginDTO)throws LogInException;
	
	public String logoutAdmin(String key)throws LogInException;

}
