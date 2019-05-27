package com.example.demo.controllers;

import com.example.demo.entities.queries.EntrepriseDetail;
import com.example.demo.entities.queries.EntrepriseTechnologie;
import com.example.demo.entities.queries.EntrepriseToInsert;
import com.example.demo.services.EntreprisesService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
	
	@Autowired
	private EntreprisesService service;
	
	//Renvoie les entreprises avec leurs détails
	@GetMapping
	public List<EntrepriseDetail> findAll(){
		return service.getAll();
	}
	
	//Renvoie les entreprises avec les technolgies utilisées
	@GetMapping("/technologie")
	public List<EntrepriseTechnologie> getByTechnologie(){
		return service.getByTechnologie();
	}
	
	//Renvoie une entreprise
	@GetMapping("/{id}")
	public Object getById(@PathVariable("id") int id){
		return service.getById(id);
	}
	
	//Créer une entreprise
	@PostMapping
	@Transactional
	public EntrepriseToInsert create(@RequestBody EntrepriseToInsert e) {
	return	service.create(e);
	}

}
