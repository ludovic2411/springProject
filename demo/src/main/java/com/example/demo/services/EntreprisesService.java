package com.example.demo.services;

import com.example.demo.repositories.EntreprisesRepo;
import com.example.demo.entities.Entreprise;
import com.example.demo.entities.Pays;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.inject.*;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.*;

@Service
public class EntreprisesService {
	
	//@Autowired
	//private EntreprisesRepo repo;
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Object[]> findAll() {
	Query query=entityManager.createNativeQuery("SELECT e.nom,e.site_web,e.mail, a.cp, a.rue,a.numero,v.nom AS ville FROM entreprises AS e INNER JOIN adresses AS a ON e.adresse=a.id INNER JOIN villes AS v on a.cp=v.cp;");
		System.out.println("found "+query.getResultList());
		//List<Object[]> objectList = query.getResultList();
		return (List<Object[]>) query.getResultList();
	}

}  
