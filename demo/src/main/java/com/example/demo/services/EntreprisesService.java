package com.example.demo.services;


import com.example.demo.entities.queries.EntrepriseDetail;

import org.springframework.stereotype.Service;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.*;

@Service
public class EntreprisesService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<EntrepriseDetail> findAll() {
	
		Query query=entityManager.createNativeQuery("SELECT e.nom,e.site_web,e.mail, a.cp, a.rue,a.numero,v.nom AS ville FROM entreprises AS e INNER JOIN adresses AS a ON e.adresse=a.id INNER JOIN villes AS v on a.cp=v.cp;");
		List<Object[]> resultList=query.getResultList();
		List<EntrepriseDetail> entreprisesList=new ArrayList();
		for(Object[] row:resultList) {
			 EntrepriseDetail entreprise=new EntrepriseDetail(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),
			 row[4].toString(),row[5].toString(),row[6].toString());
			 entreprisesList.add(entreprise);
		}
		
		return entreprisesList;
	}

}  
