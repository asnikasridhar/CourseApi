package com.application.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContentDto {
	private Integer content_id;	
	private String content_name;
	private Integer header_id;
	/**
	 * @param content_id
	 * @param content_name
	 * @param header_id
	 */
	public ContentDto(Integer content_id, String content_name, Integer header_id) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		this.header_id = header_id;
	}
	/**
	 * @return the content_id
	 */
	public Integer getContent_id() {
		return content_id;
	}
	/**
	 * @param content_id the content_id to set
	 */
	public void setContent_id(Integer content_id) {
		this.content_id = content_id;
	}
	/**
	 * @return the content_name
	 */
	public String getContent_name() {
		return content_name;
	}
	/**
	 * @param content_name the content_name to set
	 */
	public void setContent_name(String content_name) {
		this.content_name = content_name;
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
		
}
