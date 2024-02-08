package com.application.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courses.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer>{

}
