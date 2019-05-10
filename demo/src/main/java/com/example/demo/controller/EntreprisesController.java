package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Entreprise;
import com.example.demo.services.EntreprisesService;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
	
	@Autowired
	private EntreprisesService service;
	
	@GetMapping("")
	public List <Entreprise> findAll() {
		return service.findAll();
				
	}
}
