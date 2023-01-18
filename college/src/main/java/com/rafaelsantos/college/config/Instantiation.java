package com.rafaelsantos.college.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.domain.Department;
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
		
		Department department1 = new Department(null, "History", "historydepartment@gmail.com", "History department", hero);
		Department department2 = new Department(null, "Science", "sciencedepartment@gmail.com", "Science department", usb);
		Department department3 = new Department(null, "Math", "mathdepartment@gmail.com", "Math department", mnk);
		
		repository.saveAll(Arrays.asList(hero, usb, mnk));
		departmentRepository.saveAll(Arrays.asList(department1, department2, department3));
		
		hero.getDepartments().add(department1);
		usb.getDepartments().add(department2);
		mnk.getDepartments().add(department3);
		
		repository.save(hero);
		repository.save(usb);
		repository.save(mnk);
	}
}
