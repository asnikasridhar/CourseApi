package com.application.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.courses.entity.Header;

public interface HeaderRepository extends JpaRepository<Header, Integer>{

}
