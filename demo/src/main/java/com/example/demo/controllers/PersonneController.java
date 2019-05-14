package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.queries.PersonneTechnologie;
import com.example.demo.services.PersonneService;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
	
	@Autowired
	private PersonneService service;
	
	@GetMapping
	public List<PersonneTechnologie> getAll(){
		return service.getAll();
	}

}
