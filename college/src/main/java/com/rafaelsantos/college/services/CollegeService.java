package com.rafaelsantos.college.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.repositories.CollegeRepository;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepository repository;
	
	public List<College> findAll(){
		return repository.findAll();
	}
}
