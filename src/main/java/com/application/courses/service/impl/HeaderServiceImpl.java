package com.application.courses.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.courses.dto.HeaderDto;
import com.application.courses.entity.Header;
import com.application.courses.mapper.HeaderMapper;
import com.application.courses.repository.HeaderRepository;
import com.application.courses.service.HeaderService;

@Service
public class HeaderServiceImpl implements HeaderService {

	private HeaderRepository headerRepository;

	public HeaderServiceImpl(HeaderRepository headerRepository) {
		this.headerRepository = headerRepository;
	}

	@Override
	public HeaderDto createHeader(HeaderDto headerDto) {
		// TODO Auto-generated method stub
		Header header = HeaderMapper.mapToHeader(headerDto);
		Header savedHeader = headerRepository.save(header);
		return HeaderMapper.mapToHeaderDto(savedHeader);
	}

	
	@Override
	public HeaderDto getHeaderById(Integer Id) {
		// TODO Auto-generated method stub
		Header header = headerRepository
				.findById(Id)
				.orElseThrow(() -> new RuntimeException("Header Does Not Exist"));
		return HeaderMapper.mapToHeaderDto(header);
	}
	
	@Override
	public HeaderDto updateHeader(Integer id, String headerName) {
		// TODO Auto-generated method stub
		Header header = headerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Header Does Not Exist"));
		if(header != null)
		{
			header.setHeader_name(headerName);
			Header updatedHeader = headerRepository.save(header); 
			return HeaderMapper.mapToHeaderDto(updatedHeader);
		}
		else
			return null;
	}

	
	@Override
	public String deleteHeader(Integer id) {
		// TODO Auto-generated method stub
		Header header = headerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Header Does Not Exist"));
		if(header != null)
		{
			headerRepository.deleteById(id);
			return "Deleted";
		}
		return "No Records Found";
	}

	
	@Override
	public List<HeaderDto> getAllHeader() {
		// TODO Auto-generated method stub
		List<Header> headers = headerRepository.findAll();
		return headers.stream().map((header) -> HeaderMapper.mapToHeaderDto(header)).collect(Collectors.toList()) ;
	}
}
