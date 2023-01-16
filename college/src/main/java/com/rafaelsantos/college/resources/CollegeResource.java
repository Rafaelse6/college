package com.rafaelsantos.college.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.services.CollegeService;

@RestController
@RequestMapping(value = "/colleges")
public class CollegeResource {
	
	@Autowired
	private CollegeService service;
	
	@GetMapping
	public ResponseEntity<List<College>> findAll(){
		List<College>list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
