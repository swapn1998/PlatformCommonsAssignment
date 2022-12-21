package com.masai.service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.dto.StudentDTO;
import com.masai.entity.Address;
import com.masai.entity.Course;
import com.masai.entity.CurrentUserSession;
import com.masai.entity.Student;
import com.masai.exception.CourseException;
import com.masai.exception.LogInException;
import com.masai.exception.StudentException;
import com.masai.repo.AddressRepo;
import com.masai.repo.CourseRepo;
import com.masai.repo.CurrentUserSessionRepo;
import com.masai.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public Student addStudent(Student student, String key) throws StudentException, LogInException {
		
		
      Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUuid(key);
		
		if(userSession.isEmpty())
			throw new LogInException("Admin not logged in");
		
		Optional<Student> checkStudent=studentRepo.findByEmail(student.getEmail());
		
		if(checkStudent.isPresent()) {
			throw new StudentException("One student already exist with this email");
		}
		
		if(!student.getDateOfBirth().isBefore(LocalDate.now())) {
			throw new StudentException("DateOfBirth should be in past");
		}
			
		Student createdStudent= studentRepo.save(student);

		return createdStudent;
	}

	

	@Override
	public Map<String, Object> getStudentsByName( Integer page, Integer size, String name, String key) throws StudentException, LogInException {
		 Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUuid(key);
			
			if(userSession.isEmpty())
				throw new LogInException("Admin not logged in");
			
          
			
			Pageable paging = PageRequest.of(page, size);
			
			Page<Student> pageStudent = studentRepo.findByName(paging, name);

			
			List<Student> studentlist = pageStudent.getContent();
			
			if(studentlist.isEmpty()) 
				throw new StudentException("No student found with this name");
			
			Map<String, Object> response = new HashMap<String, Object>();
			
			response.put("students", studentlist);
			response.put("currentPage", pageStudent.getNumber());
			response.put("totalItem", pageStudent.getTotalElements());
			response.put("totalPages", pageStudent.getTotalPages());
			
			
			return response;
	}

	@Override
	public List<Student> getStudentsByCourseName(String name, String key)
			throws StudentException, LogInException, CourseException {
		
		Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUuid(key);
		
		if(userSession.isEmpty())
			throw new LogInException("Admin not logged in");
		
		Optional<Course> course= courseRepo.findByCourseName(name);
		
		if(course.isEmpty())
			throw new CourseException("No course found with this coursename");
		
		List<Student> studentlist= course.get().getStudents();
		if(studentlist.isEmpty())
			throw new StudentException("No student assigned to this course");	
		
		return studentlist;
	}



	@Override
	public Student updateDetails(StudentDTO studentdto) throws StudentException {
		
		Optional<Student> student= studentRepo.findStudentByIdAndDOB(studentdto.getStudentId(), studentdto.getDateOfBirth());
		
		if(student.isEmpty()) {
			throw new StudentException("No student found with given id and dob");
		}
		
		List<Address> addresslist= student.get().getAddresses();
		
		boolean flag=true;
		for(int i=0;i<addresslist.size();i++) {
			
			if(addresslist.get(i).getAddresstype().equals(studentdto.getAddress().getAddresstype())){

				
				addresslist.get(i).setArea(studentdto.getAddress().getArea());
				addresslist.get(i).setDistrict(studentdto.getAddress().getDistrict());
				addresslist.get(i).setPincode(studentdto.getAddress().getPincode());
				addresslist.get(i).setState(studentdto.getAddress().getState());
				 student.get().getAddresses().set(i, addresslist.get(i));
				flag=false;
				
			}
		}
		
		if(flag) {
		
			Address address= addressRepo.save(studentdto.getAddress());
			
			student.get().getAddresses().add(address);
		
	}
		Student updatedStudent= studentRepo.save(student.get());
		return updatedStudent;
	}
	
	

}
