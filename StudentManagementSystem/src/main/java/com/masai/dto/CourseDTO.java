package com.masai.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

	private Integer courseId;
	
	@NotNull(message = "courseName cannot be Null")
	@NotBlank(message = "courseName cannot be blank")
	@NotEmpty(message = "courseName cannot be empty")
	@Size(min = 3,max = 30,message = "courseName size should be of 3-30")
	private String courseName;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	@Size(min = 5,max = 225,message = "description size should be of 5-225")
	private String description;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	private String courseType;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	private String duration;
	
	@NotNull(message = "description cannot be Null")
	@NotBlank(message = "description cannot be blank")
	@NotEmpty(message = "description cannot be empty")
	@Size(min = 5,max = 200,message = "topics size should be of 5-200")
	private String topics;

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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public CourseDTO(Integer courseId,
			@NotNull(message = "courseName cannot be Null") @NotBlank(message = "courseName cannot be blank") @NotEmpty(message = "courseName cannot be empty") @Size(min = 3, max = 30, message = "courseName size should be of 3-30") String courseName,
			@NotNull(message = "description cannot be Null") @NotBlank(message = "description cannot be blank") @NotEmpty(message = "description cannot be empty") @Size(min = 5, max = 225, message = "description size should be of 5-225") String description,
			@NotNull(message = "description cannot be Null") @NotBlank(message = "description cannot be blank") @NotEmpty(message = "description cannot be empty") String courseType,
			@NotNull(message = "description cannot be Null") @NotBlank(message = "description cannot be blank") @NotEmpty(message = "description cannot be empty") String duration,
			@NotNull(message = "description cannot be Null") @NotBlank(message = "description cannot be blank") @NotEmpty(message = "description cannot be empty") @Size(min = 5, max = 200, message = "topics size should be of 5-200") String topics) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
		this.topics = topics;
	}

	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
