package com.application.courses.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.courses.dto.ContentDto;
import com.application.courses.service.ContentService;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "http://localhost:8080/api/content")
public class ContentController {

	private ContentService contentService;

	public ContentController(ContentService contentService) {
			this.contentService = contentService;
	}
	
	@PostMapping
	public ResponseEntity<ContentDto> addContent(@RequestBody ContentDto contentDto){
		return new ResponseEntity<>(contentService.createContent(contentDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContentDto> getContentById(@PathVariable Integer id){
		ContentDto contentDto = contentService.getContentById(id);
		return ResponseEntity.ok(contentDto);
	}
	
	@PutMapping("{id}/updateName")
	public ResponseEntity<ContentDto> updateContent(@PathVariable Integer id, @RequestBody Map<String, String>request){
		String contentName = request.get("contentName");
		return new ResponseEntity<>(contentService.updateContent(id, contentName ), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteContent(@PathVariable Integer id)
	{
		contentService.deleteContent(id);
		return ResponseEntity.ok("Content Deleted Succesfully");
	}
	
	@GetMapping
	public ResponseEntity<List<ContentDto>> getAllContents(){
		List<ContentDto> contents = contentService.getAllContent();
		return ResponseEntity.ok(contents);
	}
	
	
	
}
