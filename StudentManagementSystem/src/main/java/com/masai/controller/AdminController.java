package com.masai.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.AdminLoginDTO;
import com.masai.entity.AdminSignupData;
import com.masai.entity.Course;
import com.masai.entity.CurrentUserSession;
import com.masai.entity.Student;
import com.masai.exception.CourseException;
import com.masai.exception.LogInException;
import com.masai.exception.SignUpException;
import com.masai.exception.StudentException;
import com.masai.service.AdminLoginService;
import com.masai.service.AdminSignupService;
import com.masai.service.CourseService;
import com.masai.service.StudentService;

@RestController
public class AdminController {
	@Autowired
	private AdminSignupService adminSignupService;
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	//ADMIN SIGNUP-->
	
	@PostMapping("/register")
	public ResponseEntity<AdminSignupData> registerAdminHandler(@Valid @RequestBody AdminSignupData adminSignupData) throws SignUpException{
		AdminSignupData registereddata= adminSignupService.createAdmin(adminSignupData);
		
		return new ResponseEntity<AdminSignupData>(registereddata,HttpStatus.CREATED);
			
	}
	
	//ADMIN LOGIN-->
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginAdminHandler(@Valid @RequestBody AdminLoginDTO adminLoginDTO) throws LogInException{
		CurrentUserSession currentUserSession= adminLoginService.loginAdmin(adminLoginDTO);
		
		return new ResponseEntity<CurrentUserSession>(currentUserSession,HttpStatus.CREATED);
			
	}
	
	//ADMIN LOGOUT-->
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutAdminHandler(@RequestHeader ("key") String key) throws LogInException{
		String message= adminLoginService.logoutAdmin(key);
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
			
	}
	
	//ADMIN ADMIT A STUDENT-->
	
	@PostMapping("/admitstudent")
	public ResponseEntity<Student> registerStudentHandler(@Valid @RequestBody Student student, @RequestHeader("key") String key) throws StudentException, LogInException{
		Student registeredStudent= studentService.addStudent(student, key);
		
		return new ResponseEntity<Student>(registeredStudent,HttpStatus.CREATED);
			
	}
	
      //ADMIN UPLOAD COURSE-->
	
	
	@PostMapping("/uploadcourse")
	public ResponseEntity<Course> registerCourseHandler(@Valid @RequestBody Course course, @RequestHeader("key") String key) throws LogInException, CourseException{
		Course registeredCourse= courseService.addCourse(course, key);
		
		return new ResponseEntity<Course>(registeredCourse,HttpStatus.CREATED);
			
	}
	
	//ADMIN ASSIGN COURSE TO STUDENT-->
	
	@PostMapping("/addcoursetostudent/{cId}/{sId}")
	public ResponseEntity<List<Course>> addCourseToStudentHandler(@PathVariable Integer cId,@PathVariable Integer sId, @RequestHeader("key") String key) throws StudentException, LogInException, CourseException{
		List<Course> courselist= courseService.assignCourseToStudent(cId, sId, key);
		
		return new ResponseEntity<List<Course>>(courselist,HttpStatus.OK);
			
	}
	
	
	//ADMIN SEARCH STUDENTS BY NAME-->
	
	@GetMapping("/studentsbyname/{name}")
	public ResponseEntity<Map<String, Object>> studentsByNameHandler(@PathVariable String name, @RequestHeader("key") String key,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) throws StudentException, LogInException{
		Map<String, Object> studentPage= studentService.getStudentsByName(page, size, name, key);
		
		return new ResponseEntity<Map<String, Object>>(studentPage,HttpStatus.OK);
			
	}
	
	
	//ADMIN SEARCH STUDENTS BY COURSENAME
	
	@GetMapping("/studentsbycourse/{Cname}")
	public ResponseEntity<List<Student>> studentsByCourseHandler(@PathVariable String Cname, @RequestHeader("key") String key) throws StudentException, LogInException, CourseException{
		List<Student> studentList= studentService.getStudentsByCourseName(Cname, key);
		
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
			
	}
	
	
	
	

}
