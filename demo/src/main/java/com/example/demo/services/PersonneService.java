package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.example.demo.entities.queries.PersonneTechnologie;

@Service
public class PersonneService {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List <PersonneTechnologie> getAll(){
		
		Query query=manager.createNativeQuery("SELECT t.nom AS technologie,t.domaine,p.nom,p.prenom,p.email, p.is_recruteur FROM technologies_personnes_join_table INNER JOIN technologies AS t on t.id=technologie_id INNER JOIN personnes AS p on p.email=personne_email WHERE p.is_recruteur=0;");
		
		List<Object[]> resultSet=query.getResultList();
		List<PersonneTechnologie> personneList=new ArrayList<PersonneTechnologie>();
		for(Object[] row:resultSet) {
			PersonneTechnologie personne=new PersonneTechnologie(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),Boolean.parseBoolean(row[5].toString()));
			personneList.add(personne);
		}
		
		return personneList;
	}

}
