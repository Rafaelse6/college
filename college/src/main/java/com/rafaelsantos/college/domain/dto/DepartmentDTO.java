package com.rafaelsantos.college.domain.dto;

import java.io.Serializable;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.Department;

public class DepartmentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private String description;
	private College college;
	
	public DepartmentDTO() {}

	public DepartmentDTO(String id, String name, String email, String description, College college) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.description = description;
		this.college = college;
	}
	
	public DepartmentDTO(Department entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.description = entity.getDescription();
		this.college = entity.getCollege();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
}
