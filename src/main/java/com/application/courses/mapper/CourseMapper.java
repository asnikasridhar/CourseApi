package com.application.courses.mapper;

import com.application.courses.dto.CourseDto;
import com.application.courses.entity.Course;

public class CourseMapper {

	public static Course mapToCourse(CourseDto courseDto)
	{
		Course course = new Course(courseDto.getCourse_id(),
				courseDto.getCourse_name()
				);
		return course;

	}

	public static CourseDto mapToCourseDto(Course course)
	{
		CourseDto courseDto = new CourseDto(
				course.getCourse_id(),
				course.getCourse_name());
		return courseDto;
	}

}
