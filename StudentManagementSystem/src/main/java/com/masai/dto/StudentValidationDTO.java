package com.masai.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentValidationDTO {
	@NotNull
	private Integer studentId;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;

	
	
	
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

	public StudentValidationDTO(@NotNull Integer studentId, @NotNull LocalDate dateOfBirth) {
		super();
		this.studentId = studentId;
		this.dateOfBirth = dateOfBirth;
	}

	public StudentValidationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
