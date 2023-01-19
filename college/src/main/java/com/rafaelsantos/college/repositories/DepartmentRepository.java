package com.rafaelsantos.college.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rafaelsantos.college.domain.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
	
}
