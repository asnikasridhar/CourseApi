package com.application.courses.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.courses.dto.CourseDto;
import com.application.courses.service.CourseService;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:8080/api/course")
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
			this.courseService = courseService;
	}
	
	@PostMapping
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto){
		return new ResponseEntity<>(courseService.createCourse(courseDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Integer id){
		CourseDto courseDto = courseService.getCourseById(id);
		return ResponseEntity.ok(courseDto);
	}
	
	@PutMapping("{id}/updateName")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer id, @RequestBody Map<String, String>request){
		String courseName = request.get("courseName");
		return new ResponseEntity<>(courseService.updateCourse(id, courseName ), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id)
	{
		courseService.deleteCourse(id);
		return ResponseEntity.ok("Course Deleted Succesfully");
	}
	
	@GetMapping
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		List<CourseDto> courses = courseService.getAllCourses();
		return ResponseEntity.ok(courses);
	}
	
	
	
}
