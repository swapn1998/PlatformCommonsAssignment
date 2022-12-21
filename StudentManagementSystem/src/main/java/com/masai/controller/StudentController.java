package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.StudentDTO;
import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.service.CourseService;
import com.masai.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	//STUDENT UPDATE SELF DETAILS-->
	
	@PutMapping("/updatestudent")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody StudentDTO studentDTO) throws StudentException{
		Student updatedStudent=  studentService.updateDetails(studentDTO);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
			
	}
	
	//STUDENT GET COURSE LIST ASSIGNED TO HIM/HER-->
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> coursesAssignedToStudentHandler(@RequestHeader ("id") Integer id, @RequestHeader ("dob") String dob) throws StudentException, CourseException{
		
		LocalDate dateOfBirth= LocalDate.parse(dob);
		
		List<Course> courselist= courseService.allCoursesAssignedToStudent(id,dateOfBirth);
		
		return new ResponseEntity<List<Course>>(courselist,HttpStatus.OK);
			
	}
	
	//STUDENT LEAVE A COURSE-->
	
	@DeleteMapping("/removecourse/{courseId}")
	public ResponseEntity<List<Course>> removecoursfromAssignedStudentHandler(@PathVariable Integer courseId,@RequestHeader ("id") Integer id, @RequestHeader ("dob") String dob) throws StudentException, CourseException{
		
		LocalDate dateOfBirth= LocalDate.parse(dob);
		
		List<Course> courselist= courseService.removeCoursefromStudent(id, dateOfBirth, courseId);
		
		return new ResponseEntity<List<Course>>(courselist,HttpStatus.OK);
			
	}
	
	

}
