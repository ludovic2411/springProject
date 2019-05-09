package com.example.demo.controller;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Entreprise;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
	
	@GetMapping("")
	public static Entreprise findAll() {
		
		NativeQuery query= Session.createSQLQuery(
				"SELECT e.nom,e.site_web,e.mail, a.cp, a.rue,a.numero,v.nom  "
				+ "FROM entreprises AS e INNER JOIN adresses AS a ON e.adresse=a.id "
				+ "INNER JOIN villes AS v on a.cp=v.cp");
				
	}
}
