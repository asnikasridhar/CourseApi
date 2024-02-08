package com.application.courses.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "course")
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer course_id;
	@Column(name = "course_name")
	private String course_name;
	
	@OneToMany(mappedBy = "course")
    private List<Chapter> chapters;
	public Course() {
		super();
	}
	public Course(Integer course_id, String course_name) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	

}
