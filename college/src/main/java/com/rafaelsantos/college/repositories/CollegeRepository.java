package com.rafaelsantos.college.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rafaelsantos.college.domain.College;

public interface CollegeRepository extends MongoRepository<College, String> {

}
