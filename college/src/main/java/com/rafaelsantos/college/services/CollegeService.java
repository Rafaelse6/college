package com.rafaelsantos.college.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.dto.CollegeDTO;
import com.rafaelsantos.college.repositories.CollegeRepository;
import com.rafaelsantos.college.services.exceptions.DatabaseException;
import com.rafaelsantos.college.services.exceptions.ObjectNotFoundException;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepository repo;
	
	@Transactional(readOnly = true)
	public List<CollegeDTO> findAll(){
		List<College> list = repo.findAll();
		return list.stream().map(x -> new CollegeDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public College findById(String id) {
		Optional<College> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	@Transactional
	public CollegeDTO insert(CollegeDTO dto) {
		College entity = new College();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		
		entity = repo.save(entity);
		
		return new CollegeDTO(entity);
	}
	
	public College update(College obj) {
		College newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
    }
	
	private void updateData(College newObj, College obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(String id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	public College fromDto(CollegeDTO objDto) {
		return new College(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
