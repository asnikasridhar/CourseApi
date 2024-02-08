package com.application.courses.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.courses.dto.ContentDto;
import com.application.courses.entity.Content;
import com.application.courses.mapper.ContentMapper;
import com.application.courses.repository.ContentRepository;
import com.application.courses.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	private ContentRepository contentRepository;

	public ContentServiceImpl(ContentRepository contentRepository) {
		this.contentRepository = contentRepository;
	}

	@Override
	public ContentDto createContent(ContentDto contentDto) {
		// TODO Auto-generated method stub
		Content content = ContentMapper.mapToContent(contentDto);
		Content savedContent = contentRepository.save(content);
		return ContentMapper.mapToContentDto(savedContent);
	}

	
	@Override
	public ContentDto getContentById(Integer Id) {
		// TODO Auto-generated method stub
		Content content = contentRepository
				.findById(Id)
				.orElseThrow(() -> new RuntimeException("Content Does Not Exist"));
		return ContentMapper.mapToContentDto(content);
	}
	
	@Override
	public ContentDto updateContent(Integer id, String contentName) {
		// TODO Auto-generated method stub
		Content content = contentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Content Does Not Exist"));
		if(content != null)
		{
			content.setContent_name(contentName);
			Content updatedContent = contentRepository.save(content); 
			return ContentMapper.mapToContentDto(updatedContent);
		}
		else
			return null;
	}

	
	@Override
	public String deleteContent(Integer id) {
		// TODO Auto-generated method stub
		Content content = contentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Content Does Not Exist"));
		if(content != null)
		{
			contentRepository.deleteById(id);
			return "Deleted";
		}
		return "No Records Found";
	}

	
	@Override
	public List<ContentDto> getAllContent() {
		// TODO Auto-generated method stub
		List<Content> contents = contentRepository.findAll();
		return contents.stream().map((content) -> ContentMapper.mapToContentDto(content)).collect(Collectors.toList()) ;
	}
}
