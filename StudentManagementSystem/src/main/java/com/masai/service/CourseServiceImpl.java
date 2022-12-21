package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.Course;
import com.masai.entity.CurrentUserSession;
import com.masai.entity.Student;
import com.masai.exception.CourseException;
import com.masai.exception.LogInException;
import com.masai.exception.StudentException;
import com.masai.repo.CourseRepo;
import com.masai.repo.CurrentUserSessionRepo;
import com.masai.repo.StudentRepo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Course addCourse(Course course, String key) throws LogInException, CourseException {
		 Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUuid(key);
			
			if(userSession.isEmpty())
				throw new LogInException("Admin not logged in");
			
			Optional<Course> checkCourse= courseRepo.findByCourseName(course.getCourseName());
			
			if(checkCourse.isPresent())
				throw new CourseException("Course already exist with this Coursename");				
						
		
			Course addedCourse= courseRepo.save(course);		
		    return addedCourse;
	}

	@Override
	public List<Course> assignCourseToStudent(Integer courseId, Integer studentId, String key)
			throws LogInException, StudentException, CourseException {
		
		Optional<CurrentUserSession> userSession=currentUserSessionRepo.findByUuid(key);
		
		if(userSession.isEmpty())
			throw new LogInException("Admin not logged in");
		
		
		
		Optional<Course> course= courseRepo.findById(courseId);
		
		if(course.isEmpty()) {
			throw new CourseException("No course found with given courseid");
		}
		
		Optional<Student> student= studentRepo.findById(studentId);
		
		if(student.isEmpty()) {
			throw new StudentException("No student found with this given studentid");
		}
		
		student.get().getCourses().add(course.get());
		
		course.get().getStudents().add(student.get());
		
		Student updatedStudent= studentRepo.save(student.get());
		
		return updatedStudent.getCourses();
		
	}

	@Override
	public List<Course> allCoursesAssignedToStudent(Integer id, LocalDate dob)
			throws StudentException, CourseException {
	
Optional<Student> student= studentRepo.findStudentByIdAndDOB(id, dob);
		
		if(student.isEmpty()) {
			throw new StudentException("No student found with given id and dob");
		}
		
		List<Course> courselist= student.get().getCourses();
		
		if(courselist.isEmpty()) {
			throw new CourseException("No course assigned to the student");
		}	
		
		return courselist;
	}

	@Override
	public List<Course> removeCoursefromStudent(Integer stuid, LocalDate dob, Integer courseId)
			throws StudentException, CourseException {
		
       Optional<Student> student= studentRepo.findStudentByIdAndDOB(stuid, dob);
		
		if(student.isEmpty()) {
			throw new StudentException("No student found with given id and dob");
		}
		
      Optional<Course> course= courseRepo.findById(courseId);
		
		if(course.isEmpty()) {
			throw new CourseException("No course found with given courseid");
		}
		
		boolean flag=true;
		List<Course> courselist=student.get().getCourses();
		
		for(int i=0;i<courselist.size();i++) {
			
			if(courselist.get(i).getCourseId()==courseId) {
				student.get().getCourses().remove(i);
				flag=false;
			}
		}
		if(flag) {
			
			throw new StudentException("Student not assigned to the given course");
		}
		
      List<Student> studentlist=course.get().getStudents();
		
		for(int i=0;i<studentlist.size();i++) {
			
			if(studentlist.get(i).getStudentId()==stuid) {
				course.get().getStudents().remove(i);
			}
		}
		
		Student updatedStudent= studentRepo.save(student.get());
		
		if(updatedStudent.getCourses().isEmpty()) {
			throw new CourseException("Course removed successfully, Student has no more courses");
		}
		
		return updatedStudent.getCourses();
	}

}
