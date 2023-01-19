package com.rafaelsantos.college.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelsantos.college.domain.Department;
import com.rafaelsantos.college.domain.dto.DepartmentDTO;
import com.rafaelsantos.college.repositories.DepartmentRepository;
import com.rafaelsantos.college.services.exceptions.ObjectNotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	public DepartmentDTO findById(String id) {
		Optional<Department> obj = repository.findById(id);
		Department entity = obj.orElseThrow(() ->new ObjectNotFoundException("Object not found"));
		return new DepartmentDTO(entity);
	}
}
