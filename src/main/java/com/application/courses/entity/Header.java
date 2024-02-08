package com.application.courses.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "header")
@Entity
public class Header {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer header_id;	
	@Column(name = "header_name")
	private String header_name;
	
	@ManyToOne
	@JoinColumn(name = "chapter_id", nullable = false, insertable = false, updatable = false) // chapter_id is the foreign key in Chapter
    private Chapter chapter;
	
	private Integer chapter_id;
	
	@OneToMany(mappedBy = "header")
    private List<Content> contents;
	public Header() {
		super();
	}


	/**
	 * @param header_id
	 * @param header_name
	 * @param chapter_id
	 */
	public Header(Integer header_id, String header_name, Integer chapter_id) {
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
