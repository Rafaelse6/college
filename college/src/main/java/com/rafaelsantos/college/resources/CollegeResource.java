package com.rafaelsantos.college.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.dto.CollegeDTO;
import com.rafaelsantos.college.services.CollegeService;

@RestController
@RequestMapping(value = "/colleges")
public class CollegeResource {
	
	@Autowired
	private CollegeService service;
	
	@GetMapping
	public ResponseEntity<List<CollegeDTO>> findAll(){
		List<College> list = service.findAll();
		List<CollegeDTO> listDto = list.stream().map(x -> new CollegeDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CollegeDTO> findById(@PathVariable String id){
		College obj = service.findById(id);
		return ResponseEntity.ok().body(new CollegeDTO(obj));
	}
}
