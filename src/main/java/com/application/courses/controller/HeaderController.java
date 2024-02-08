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

import com.application.courses.dto.HeaderDto;
import com.application.courses.service.HeaderService;

@RestController
@RequestMapping("/api/header")
@CrossOrigin(origins = "http://localhost:8080/api/header")
public class HeaderController {

	private HeaderService headerService;

	public HeaderController(HeaderService headerService) {
			this.headerService = headerService;
	}
	
	@PostMapping
	public ResponseEntity<HeaderDto> addHeader(@RequestBody HeaderDto headerDto){
		return new ResponseEntity<>(headerService.createHeader(headerDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HeaderDto> getHeaderById(@PathVariable Integer id){
		HeaderDto headerDto = headerService.getHeaderById(id);
		return ResponseEntity.ok(headerDto);
	}
	
	@PutMapping("{id}/updateName")
	public ResponseEntity<HeaderDto> updateHeader(@PathVariable Integer id, @RequestBody Map<String, String>request){
		String headerName = request.get("headerName");
		return new ResponseEntity<>(headerService.updateHeader(id, headerName ), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHeader(@PathVariable Integer id)
	{
		headerService.deleteHeader(id);
		return ResponseEntity.ok("Header Deleted Succesfully");
	}
	
	@GetMapping
	public ResponseEntity<List<HeaderDto>> getAllHeaders(){
		List<HeaderDto> headers = headerService.getAllHeader();
		return ResponseEntity.ok(headers);
	}
	
	
	
}
