package com.masai.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import com.masai.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDTO {
	
	@NotNull
	private Integer studentId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	
	@NotNull
	private String name;
	
	@NotNull
	private String parentsName;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	
	@NotNull
	private Address address;

	
	
	
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentsName() {
		return parentsName;
	}

	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public StudentDTO(@NotNull Integer studentId, LocalDate dateOfBirth, @NotNull String name,
			@NotNull String parentsName, @Email @NotNull String email,
			@NotNull @Pattern(regexp = "[0-9]{10}", message = "Mobile number must have 10 digits") String mobileNumber,
			@NotNull Address address) {
		super();
		this.studentId = studentId;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.parentsName = parentsName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
