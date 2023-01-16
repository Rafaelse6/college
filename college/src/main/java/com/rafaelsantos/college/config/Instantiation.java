package com.rafaelsantos.college.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafaelsantos.college.domain.College;
import com.rafaelsantos.college.repositories.CollegeRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private CollegeRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		College hero = new College(null, "Boku no Hero College", "hero@gmail.com");
		College usb = new College(null, "USB College", "usb@gmail.com");
		College mnk = new College(null, "MNK College", "mnk@gmail.com");
		
		repository.saveAll(Arrays.asList(hero, usb, mnk));
	}
}
