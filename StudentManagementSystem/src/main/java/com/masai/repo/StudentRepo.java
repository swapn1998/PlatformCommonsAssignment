package com.masai.repo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	
	public Optional<Student> findByEmail(String email);
	
	public Page<Student> findByName(Pageable pageable, String name);
	
	
	@Query("from com.masai.entity.Student s where s.studentId=?1 and s.dateOfBirth=?2")
	public Optional<Student> findStudentByIdAndDOB(Integer Id, LocalDate dob);

}
