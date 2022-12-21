package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminSignupData {

		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer adminId;


		@NotNull
		@Size(min=5,max=12)
		private String userName;

		@NotNull
		@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
		private String password;

		@NotNull
		@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
		private String mobileNo;

		@Email
		@NotNull
		private String email;

		public Integer getAdminId() {
			return adminId;
		}

		public void setAdminId(Integer adminId) {
			this.adminId = adminId;
		}

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

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public AdminSignupData(Integer adminId, @NotNull @Size(min = 5, max = 12) String userName,
				@NotNull @Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.") String password,
				@NotNull @Pattern(regexp = "[0-9]{10}", message = "Mobile number must have 10 digits") String mobileNo,
				@Email @NotNull String email) {
			super();
			this.adminId = adminId;
			this.userName = userName;
			this.password = password;
			this.mobileNo = mobileNo;
			this.email = email;
		}

		public AdminSignupData() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		
	}



