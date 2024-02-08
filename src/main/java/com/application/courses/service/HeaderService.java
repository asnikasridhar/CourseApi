package com.application.courses.service;

import java.util.List;

import com.application.courses.dto.HeaderDto;

public interface HeaderService {

	HeaderDto createHeader (HeaderDto header);
	
	HeaderDto getHeaderById(Integer Id);
	
	HeaderDto updateHeader(Integer id, String headerName);
	
	List<HeaderDto> getAllHeader();
	
	String deleteHeader(Integer id);
	
}