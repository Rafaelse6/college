package com.rafaelsantos.college.domain.dto;

import java.io.Serializable;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.Student;

public class StudentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer semester;
	private College college;
	
	public StudentDTO() {}

	public StudentDTO(String name, Integer semester, College college) {
		super();
		this.name = name;
		this.semester = semester;
		this.college = college;
	}
	
	public StudentDTO(Student entity) {
		
		this.name = entity.getName();
		this.semester = entity.getSemester();
		this.college = entity.getCollege();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
}
