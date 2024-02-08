package com.application.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChapterDto {
	private Integer chapter_id;	
	private String chapter_name;
	private Integer course_id;
	/**
	 * @param chapter_id
	 * @param course_id
	 * @param chapter_name
	 */
	public ChapterDto(Integer chapter_id, String chapter_name, Integer course_id) {
		super();
		this.chapter_id = chapter_id;
		this.course_id = course_id;
		this.chapter_name = chapter_name;
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
	/**
	 * @return the course_id
	 */
	public Integer getCourse_id() {
		return course_id;
	}
	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	/**
	 * @return the chapter_name
	 */
	public String getChapter_name() {
		return chapter_name;
	}
	/**
	 * @param chapter_name the chapter_name to set
	 */
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}

	
}
