package com.application.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courses.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
