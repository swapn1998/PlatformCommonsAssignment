package com.masai.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {
	
	public Optional<Course> findByCourseName( String courseName);
	
	

}
