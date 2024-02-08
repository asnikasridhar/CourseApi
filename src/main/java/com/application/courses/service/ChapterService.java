package com.application.courses.service;

import java.util.List;

import com.application.courses.dto.ChapterDto;

public interface ChapterService {

	ChapterDto createChapter (ChapterDto chapter);
	
	ChapterDto getChapterById(Integer Id);
	
	ChapterDto updateChapter(Integer id, String chapterName);
	
	List<ChapterDto> getAllChapter();
	
	String deleteChapter(Integer id);
	
}