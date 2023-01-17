package com.rafaelsantos.college.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.dto.CollegeDTO;
import com.rafaelsantos.college.repositories.CollegeRepository;
import com.rafaelsantos.college.services.exceptions.ObjectNotFoundException;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepository repository;
	
	public List<College> findAll(){
		return repository.findAll();
	}
	
	public College findById(String id) {
		Optional<College> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	@Transactional
	public CollegeDTO insert(CollegeDTO dto) {
		College entity = new College();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		
		entity = repository.save(entity);
		
		return new CollegeDTO(entity);
	}
}
