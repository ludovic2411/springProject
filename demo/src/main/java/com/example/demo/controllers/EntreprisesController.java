package com.example.demo.controllers;

import com.example.demo.entities.queries.EntrepriseDetail;
import com.example.demo.entities.queries.EntrepriseTechnologie;
import com.example.demo.services.EntreprisesService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
	
	@Autowired
	private EntreprisesService service;
	
	@GetMapping
	public List<EntrepriseDetail> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/technologie")
	public List<EntrepriseTechnologie> getByTechnologie(){
		return service.getByTechnologie();
	}
	
	@GetMapping("/{id}")
	public Object getById(@PathVariable("id") int id){
		return service.getById(id);
	}

}
