package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import com.masai.entity.Course;
import com.masai.exception.CourseException;
import com.masai.exception.LogInException;
import com.masai.exception.StudentException;

public interface CourseService {
	
	public Course addCourse(Course course, String key)throws LogInException, CourseException;
	
	
	public List<Course> assignCourseToStudent(Integer courseId, Integer studentId, String key)throws LogInException, StudentException, CourseException;

	public List<Course> allCoursesAssignedToStudent(Integer id, LocalDate dob)throws StudentException,CourseException;
	
	public List<Course> removeCoursefromStudent(Integer stuid, LocalDate dob, Integer courseId)throws StudentException,CourseException;
	
	
}
