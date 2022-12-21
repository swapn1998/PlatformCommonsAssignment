package com.masai.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.masai.entity.CurrentUserSession;
import com.masai.entity.Student;
import com.masai.enums.Gender;
import com.masai.repo.CurrentUserSessionRepo;
import com.masai.repo.StudentRepo;
import com.masai.service.StudentService;
import com.masai.service.StudentServiceImpl;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentServiceImplTest {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@MockBean
	private StudentService studentService;
	
	@MockBean
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	@MockBean
	private StudentRepo studentRepo;
	
	@Test
	public void addStudent() throws Exception{
		
		
		CurrentUserSession cuss= new CurrentUserSession();
		
		cuss.setId(1);
		cuss.setLocalDateTime(LocalDateTime.now());
		cuss.setUserName("sangram");
		cuss.setUuid("123456");
		
		Optional<CurrentUserSession> currentSession= Optional.of(cuss);
		
		Optional<Student> studentOptional=Optional.empty();
		
		Student testStudent= new Student();
		
		testStudent.setStudentId(2);
		testStudent.setName("sang");
		testStudent.setParentsName("sangr");
		testStudent.setMobileNumber("1234567890");
		
		Gender gender = Gender.valueOf("MALE");
		testStudent.setGender(gender);
		LocalDate ld= LocalDate.parse("2022-11-22");
		testStudent.setDateOfBirth(ld);
		testStudent.setAddresses(null);
		testStudent.setCourses(null);
		
		Mockito.when(studentService.addStudent(testStudent, "1234")).thenReturn(testStudent);
		Mockito.when(currentUserSessionRepo.findByUuid("1234")).thenReturn(currentSession);
		Mockito.when(studentRepo.findByEmail(testStudent.getEmail())).thenReturn(studentOptional);
		
		
		
		assertThat(studentServiceImpl.addStudent(testStudent, "1234")).isEqualTo(testStudent);
		
		
		
		
		
	}

}
