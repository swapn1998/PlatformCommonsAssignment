package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
    
	@NotNull
	private String courseName;
	
	@NotNull
	private String description;
	
	@NotNull
	private String courseType;
	
	@NotNull
	private Double duration;
	
	@ElementCollection
	private List<String> topics;
	

	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
	private List<Student> students;


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCourseType() {
		return courseType;
	}


	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}


	public Double getDuration() {
		return duration;
	}


	public void setDuration(Double duration) {
		this.duration = duration;
	}


	public List<String> getTopics() {
		return topics;
	}


	public void setTopics(List<String> topics) {
		this.topics = topics;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Course(Integer courseId, @NotNull String courseName, @NotNull String description, @NotNull String courseType,
			@NotNull Double duration, List<String> topics, List<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
		this.topics = topics;
		this.students = students;
	}


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
