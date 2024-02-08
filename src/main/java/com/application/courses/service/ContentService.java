package com.application.courses.service;

import java.util.List;

import com.application.courses.dto.ContentDto;

public interface ContentService {

	ContentDto createContent (ContentDto content);
	
	ContentDto getContentById(Integer Id);
	
	ContentDto updateContent(Integer id, String contentName);
	
	List<ContentDto> getAllContent();
	
	String deleteContent(Integer id);
	
}