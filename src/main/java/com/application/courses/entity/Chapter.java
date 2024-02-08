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
@Table(name = "chapter")
@Entity
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer chapter_id;	
	@Column(name = "chapter_name")
	private String chapter_name;
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false) // course_id is the foreign key in Chapter
    private Course course;
	
	private Integer course_id;
	
	@OneToMany(mappedBy = "chapter")
    private List<Header> headers;
	public Chapter() {
		super();
	}

	public Chapter(Integer chapter_id, String chapter_name, Integer course_id) {
		super();
		this.chapter_id = chapter_id;
		this.chapter_name = chapter_name;
		this.course_id = course_id;
		
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

}
