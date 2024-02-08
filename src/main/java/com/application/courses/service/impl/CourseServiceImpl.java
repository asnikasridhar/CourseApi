package com.application.courses.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.courses.dto.CourseDto;
import com.application.courses.entity.Course;
import com.application.courses.mapper.CourseMapper;
import com.application.courses.repository.CourseRepository;
import com.application.courses.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		// TODO Auto-generated method stub
		Course course =  CourseMapper.mapToCourse(courseDto);
		Course savedCourse = courseRepository.save(course);
		return CourseMapper.mapToCourseDto(savedCourse);
	}

	@Override
	public CourseDto getCourseById(Integer Id)  {
		// TODO Auto-generated method stub
		Course course = courseRepository
				.findById(Id)
				.orElseThrow(() -> new RuntimeException("Course Does Not Exist"));
		return CourseMapper.mapToCourseDto(course);
	}

	@Override
	public CourseDto updateCourse(Integer id, String courseName) {
		// TODO Auto-generated method stub
		
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course Does Not Exist"));
		if (course != null)
		{
			course.setCourse_name(courseName);
			Course updatedCourse = courseRepository.save(course);
			return CourseMapper.mapToCourseDto(updatedCourse);
		}
		else 
			return null;		
	}

	@Override
	public String deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course Does Not Exist"));
		if (course != null)
		{
			courseRepository.deleteById(id);
			return "Deleted";
		}
		else
			return "No Records Found";
	}

	@Override
	public List<CourseDto> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = courseRepository.findAll();
		return courses.stream().map((course) -> CourseMapper.mapToCourseDto(course)).collect(Collectors.toList());
		
	}

}
