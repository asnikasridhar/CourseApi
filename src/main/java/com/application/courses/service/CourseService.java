package com.application.courses.service;

import java.util.List;

import com.application.courses.dto.CourseDto;

public interface CourseService {

	CourseDto createCourse (CourseDto course);
	
	CourseDto getCourseById(Integer Id);
	
	CourseDto updateCourse(Integer id, String courseName);
	
	List<CourseDto> getAllCourses();
	
	String deleteCourse(Integer id);
	
}