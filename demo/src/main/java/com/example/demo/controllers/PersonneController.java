package com.example.demo.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.base.Personne;
import com.example.demo.entities.joined.RecruteurEntrepriseJoinTable;
import com.example.demo.entities.queries.EntrepriseLikee;
import com.example.demo.entities.queries.PersonneTechnologie;
import com.example.demo.services.PersonneService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personnes")
public class PersonneController {
	
	@Autowired
	private PersonneService service;
	
	//Renvoie toutes les personnes
	@GetMapping
	public List<Personne> getAll(){
		return service.getAll();
	}
	//Renvoie une personne
	@GetMapping("/find")
	public Personne getById(@RequestParam(value="email") String email) {
		return service.getById(email);
	}
	//Renvoie les entreprises enregistrées par une personnes
	@GetMapping("/favorites")
	public List<EntrepriseLikee> getFavorites(@RequestParam(value="email") String email){
		return service.getFavorites(email);
	}
	
	//Créer une personne
	@Transactional
	@PostMapping
	public Personne create(@RequestBody Personne p) {
		return service.create(p);
	}
	
	//Ajoute une entreprise dans la liste des entreprises
	@Transactional
	@PostMapping("/favorites")
	public List <EntrepriseLikee> createFavorite(@RequestBody RecruteurEntrepriseJoinTable e,@RequestParam(value="email") String email) {
		return service.createFavorite(e, email);
	}

}
