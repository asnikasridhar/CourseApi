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

import com.application.courses.dto.ChapterDto;
import com.application.courses.service.ChapterService;

@RestController
@RequestMapping("/api/chapter")
@CrossOrigin(origins = "http://localhost:8080/api/chapter")
public class ChapterController {

	private ChapterService chapterService;

	public ChapterController(ChapterService chapterService) {
			this.chapterService = chapterService;
	}
	
	@PostMapping
	public ResponseEntity<ChapterDto> addChapter(@RequestBody ChapterDto chapterDto){
		return new ResponseEntity<>(chapterService.createChapter(chapterDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ChapterDto> getChapterById(@PathVariable Integer id){
		ChapterDto chapterDto = chapterService.getChapterById(id);
		return ResponseEntity.ok(chapterDto);
	}
	
	@PutMapping("{id}/updateName")
	public ResponseEntity<ChapterDto> updateChapter(@PathVariable Integer id, @RequestBody Map<String, String>request){
		String chapterName = request.get("chapterName");
		return new ResponseEntity<>(chapterService.updateChapter(id, chapterName ), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChapter(@PathVariable Integer id)
	{
		chapterService.deleteChapter(id);
		return ResponseEntity.ok("Chapter Deleted Succesfully");
	}
	
	@GetMapping
	public ResponseEntity<List<ChapterDto>> getAllChapters(){
		List<ChapterDto> chapters = chapterService.getAllChapter();
		return ResponseEntity.ok(chapters);
	}
	
	
	
}
