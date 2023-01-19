package com.rafaelsantos.college.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.Department;
import com.rafaelsantos.college.domain.dto.StudentDTO;
import com.rafaelsantos.college.repositories.CollegeRepository;
import com.rafaelsantos.college.repositories.DepartmentRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private CollegeRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		departmentRepository.deleteAll();
		
		College hero = new College(null, "Boku no Hero College", "hero@gmail.com");
		College usb = new College(null, "USB College", "usb@gmail.com");
		College mnk = new College(null, "MNK College", "mnk@gmail.com");
		
		repository.saveAll(Arrays.asList(hero, usb, mnk));
		
		Department department1 = new Department(null, "History", "historydepartment@gmail.com", "History department", hero);
		Department department2 = new Department(null, "Science", "sciencedepartment@gmail.com", "Science department", usb);
		Department department3 = new Department(null, "Math", "mathdepartment@gmail.com", "Math department", mnk);
		
		StudentDTO s1 = new StudentDTO(null, "Anna", 1, hero);
		StudentDTO s2 = new StudentDTO(null, "Bob", 2, usb);
		StudentDTO s3 = new StudentDTO(null, "Alex", 3, mnk);
		
		department1.getStudents().add(s1);
		department2.getStudents().add(s2);
		department3.getStudents().add(s3);
		
		departmentRepository.saveAll(Arrays.asList(department1, department2, department3));
		
		hero.getDepartments().add(department1);
		usb.getDepartments().add(department2);
		mnk.getDepartments().add(department3);
		
		repository.save(hero);
		repository.save(usb);
		repository.save(mnk);
	}
}
