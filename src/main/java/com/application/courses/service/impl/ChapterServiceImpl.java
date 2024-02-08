package com.application.courses.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.courses.dto.ChapterDto;
import com.application.courses.entity.Chapter;
import com.application.courses.mapper.ChapterMapper;
import com.application.courses.repository.ChapterRepository;
import com.application.courses.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

	private ChapterRepository chapterRepository;

	public ChapterServiceImpl(ChapterRepository chapterRepository) {
		this.chapterRepository = chapterRepository;
	}

	@Override
	public ChapterDto createChapter(ChapterDto chapterDto) {
		// TODO Auto-generated method stub
		Chapter chapter = ChapterMapper.mapToChapter(chapterDto);
		Chapter savedChapter = chapterRepository.save(chapter);
		return ChapterMapper.mapToChapterDto(savedChapter);
	}

	
	@Override
	public ChapterDto getChapterById(Integer Id) {
		// TODO Auto-generated method stub
		Chapter chapter = chapterRepository
				.findById(Id)
				.orElseThrow(() -> new RuntimeException("Chapter Does Not Exist"));
		return ChapterMapper.mapToChapterDto(chapter);
	}
	
	@Override
	public ChapterDto updateChapter(Integer id, String chapterName) {
		// TODO Auto-generated method stub
		Chapter chapter = chapterRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Chapter Does Not Exist"));
		if(chapter != null)
		{
			chapter.setChapter_name(chapterName);
			Chapter updatedChapter = chapterRepository.save(chapter); 
			return ChapterMapper.mapToChapterDto(updatedChapter);
		}
		else
			return null;
	}

	
	@Override
	public String deleteChapter(Integer id) {
		// TODO Auto-generated method stub
		Chapter chapter = chapterRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Chapter Does Not Exist"));
		if(chapter != null)
		{
			chapterRepository.deleteById(id);
			return "Deleted";
		}
		return "No Records Found";
	}

	
	@Override
	public List<ChapterDto> getAllChapter() {
		// TODO Auto-generated method stub
		List<Chapter> chapters = chapterRepository.findAll();
		return chapters.stream().map((chapter) -> ChapterMapper.mapToChapterDto(chapter)).collect(Collectors.toList()) ;
	}
}
