package com.application.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeaderDto {
	private Integer header_id;	
	private String header_name;
	private Integer chapter_id;
	/**
	 * @param header_id
	 * @param header_name
	 * @param chapter_id
	 */
	public HeaderDto(Integer header_id, String header_name, Integer chapter_id) {
		super();
		this.header_id = header_id;
		this.header_name = header_name;
		this.chapter_id = chapter_id;
	}
	/**
	 * @return the header_id
	 */
	public Integer getHeader_id() {
		return header_id;
	}
	/**
	 * @param header_id the header_id to set
	 */
	public void setHeader_id(Integer header_id) {
		this.header_id = header_id;
	}
	/**
	 * @return the header_name
	 */
	public String getHeader_name() {
		return header_name;
	}
	/**
	 * @param header_name the header_name to set
	 */
	public void setHeader_name(String header_name) {
		this.header_name = header_name;
	}
	/**
	 * @return the chapter_id
	 */
	public Integer getChapter_id() {
		return chapter_id;
	}
	/**
	 * @param chapter_id the chapter_id to set
	 */
	public void setChapter_id(Integer chapter_id) {
		this.chapter_id = chapter_id;
	}
	
	
	

	
}
