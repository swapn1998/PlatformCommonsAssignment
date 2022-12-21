package com.masai.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;

	@NotNull
	private String name;
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;
	
	@NotNull
	private Gender gender;
	
	@NotNull
	private String parentsName;
	
	@Email(message = "kindly pass a valid email")
	@NotNull
	private String email;
	
	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses= new ArrayList<Address>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courses= new ArrayList<Course>();

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(Integer studentId, @NotNull String name, @NotNull LocalDate dateOfBirth, @NotNull Gender gender,
			@NotNull String parentsName, @Email(message = "kindly pass a valid email") @NotNull String email,
			@NotNull @Pattern(regexp = "[0-9]{10}", message = "Mobile number must have 10 digits") String mobileNumber,
			List<Address> addresses, List<Course> courses) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.parentsName = parentsName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.addresses = addresses;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
