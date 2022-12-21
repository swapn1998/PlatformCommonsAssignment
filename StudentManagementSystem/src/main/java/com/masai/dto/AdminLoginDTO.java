package com.masai.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class AdminLoginDTO {

	@NotNull
	private String userName;
	@NotNull
	private String password;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminLoginDTO(@NotNull String userName, @NotNull String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public AdminLoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
