package com.example.demo.services;


import com.example.demo.entities.queries.EntrepriseDetail;
import com.example.demo.entities.queries.EntrepriseTechnologie;

import org.springframework.stereotype.Service;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.*;

@Service
public class EntreprisesService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<EntrepriseDetail> getAll() {
	
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
	
	public List<EntrepriseTechnologie> getByTechnologie(){
		
		Query query=entityManager.createNativeQuery("SELECT t.nom AS technologie, t.domaine, e.nom AS entreprise FROM entreprises AS e INNER JOIN technologies_entreprises_join_table AS v ON e.id=v.entreprise_id INNER JOIN technologies AS t ON v.technologie_id=t.id;");
		List<Object[]> resultList=query.getResultList();
		List<EntrepriseTechnologie> entreprisesTechnoList=new ArrayList();
		
		for(Object[] row:resultList) {
			EntrepriseTechnologie entreprise= new EntrepriseTechnologie(row[0].toString(),row[1].toString(),row[2].toString());
			entreprisesTechnoList.add(entreprise);
		}
		return entreprisesTechnoList;
	}
}  
