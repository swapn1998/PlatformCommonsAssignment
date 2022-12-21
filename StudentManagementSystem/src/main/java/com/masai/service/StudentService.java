package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.dto.StudentDTO;
import com.masai.entity.Student;
import com.masai.exception.CourseException;
import com.masai.exception.LogInException;
import com.masai.exception.StudentException;

public interface StudentService {
	
	
	public Student addStudent(Student student, String key)throws StudentException, LogInException;
	
	public Student updateDetails(StudentDTO studentdto)throws StudentException;
	
	public Map<String, Object> getStudentsByName(Integer page, Integer size,String name, String key)throws StudentException, LogInException;
	
	public List<Student> getStudentsByCourseName(String name, String key) throws StudentException, LogInException, CourseException;
	
    

}
