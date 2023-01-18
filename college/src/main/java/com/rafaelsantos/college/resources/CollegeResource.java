package com.rafaelsantos.college.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		List<CollegeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CollegeDTO> findById(@PathVariable String id){
		College obj = service.findById(id);
		return ResponseEntity.ok().body(new CollegeDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<CollegeDTO> insert(@RequestBody CollegeDTO objDto){
		objDto = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(objDto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody CollegeDTO objDto, @PathVariable String id){
		College obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
