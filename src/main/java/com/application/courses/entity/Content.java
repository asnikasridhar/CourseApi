package com.application.courses.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "content")
@Entity
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer content_id;	
	@Column(name = "content_name")
	private String content_name;
	
	@ManyToOne
	@JoinColumn(name = "header_id", nullable = false, insertable = false, updatable = false) // header_id is the foreign key in Chapter
    private Header header;
	
	private Integer header_id;
	
	public Content() {
		super();
	}


	/**
	 * @param content_id
	 * @param content_name
	 * @param chapter_id
	 */
	public Content(Integer content_id, String content_name, Integer header_id) {
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
