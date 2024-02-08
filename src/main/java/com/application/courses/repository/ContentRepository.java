package com.application.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courses.entity.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>{

}
