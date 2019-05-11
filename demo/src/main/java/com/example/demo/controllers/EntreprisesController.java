package com.example.demo.controllers;

import com.example.demo.entities.Entreprise;
import com.example.demo.entities.Pays;
import com.example.demo.services.EntreprisesService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.inject.*;

import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
	
	@Autowired
	private EntreprisesService service;
	
	@GetMapping
	public List<Object[]> findAll(){
		return service.findAll();
	}

}
