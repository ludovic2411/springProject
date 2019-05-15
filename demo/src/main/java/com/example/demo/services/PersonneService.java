package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.example.demo.entities.base.Personne;
import com.example.demo.entities.queries.EntrepriseLikee;
import com.example.demo.entities.queries.PersonneTechnologie;

@Service
public class PersonneService {
	
	@PersistenceContext
	private EntityManager manager;
	
	//Retourne la liste des technologies maîtrisées par les personnes
//	public List <PersonneTechnologie> getAll(){
//		
//		Query query=manager.createNativeQuery("SELECT t.nom AS technologie,t.domaine,p.nom,p.prenom,p.email, p.is_recruteur FROM technologies_personnes_join_table INNER JOIN technologies AS t on t.id=technologie_id INNER JOIN personnes AS p on p.email=personne_email WHERE p.is_recruteur=0;");
//		
//		List<Object[]> resultSet=query.getResultList();
//		List<PersonneTechnologie> personneList=new ArrayList<PersonneTechnologie>();
//		for(Object[] row:resultSet) {
//			PersonneTechnologie personne=new PersonneTechnologie(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),Boolean.parseBoolean(row[5].toString()));
//			personneList.add(personne);
//		}
//		
//		return personneList;
//	}
	
	
	//Retourne les technologie utilisées par une personne
//	public PersonneTechnologie getById(String email) {
//		System.out.println(email);
//		Query query=manager.createNativeQuery("SELECT t.nom AS technologie,t.domaine,p.nom,p.prenom,p.email, p.is_recruteur FROM technologies_personnes_join_table INNER JOIN technologies AS t on t.id=technologie_id INNER JOIN personnes AS p on p.email=personne_email WHERE p.is_recruteur=0 AND p.email=?;");
//		query.setParameter(1, email);
//		List<Object[]> resultSet=query.getResultList();
//		List<PersonneTechnologie> personneList=new ArrayList<PersonneTechnologie>();
//		for(Object[] row:resultSet) {
//			PersonneTechnologie personne=new PersonneTechnologie(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),Boolean.parseBoolean(row[5].toString()));
//			personneList.add(personne);
//		}
//		
//		return personneList.get(0);
//	}
	
	//Retourne toutes les personnes de la table peronnes
	public List<Personne> getAll(){
		
		Query query=manager.createNativeQuery("SELECT p.email, p.nom, p.prenom, p.telephone, p.is_recruteur FROM personnes AS p;");
		List<Object[]> resultSet=query.getResultList();
		List<Personne> personneList= new ArrayList<Personne>();
		
		for(Object[] row:resultSet) {
			Personne personne=new Personne(row[0].toString(),row[1].toString(),row[2].toString(),Long.parseLong(row[3].toString()),"Mot de passe non consultable",Boolean.parseBoolean(row[4].toString()));
			personneList.add(personne);
		}
		return personneList;
	}
	
	//Retourne une personne identifiée par son email, son nom ou son prénom
	public Personne getById(String email) {
		Personne result=null;
		Query query=manager.createNativeQuery("SELECT p.email, p.nom, p.prenom, p.telephone, p.is_recruteur FROM personnes AS p WHERE p.email=?");
		query.setParameter(1, email);
		List<Object[]> resultSet=query.getResultList();
		List<Personne> personneList= new ArrayList<Personne>();
		
		for(Object[] row:resultSet) {
			Personne personne=new Personne(row[0].toString(),row[1].toString(),row[2].toString(),Long.parseLong(row[3].toString()),"Mot de passe non consultable",Boolean.parseBoolean(row[4].toString()));
			personneList.add(personne);
		}
		if(!personneList.isEmpty()) {
			result=personneList.get(0);
		}
		return result;
	}
	
	//Retourne les entreprises enregistrées par une personne
	
	public List<EntrepriseLikee> getFavorites(String email){
		Query query=manager.createNativeQuery("SELECT e.nom AS entreprise_likee, p.nom, p.prenom  FROM recruteur_entreprise_join_table AS j INNER JOIN entreprises AS e ON e.id=j.entreprise_id INNER JOIN personnes AS p on p.email=j.recruteur_email WHERE p.email=? AND p.is_recruteur=0;");
		query.setParameter(1, email);
		List<Object[]> resultSet=query.getResultList();
		List<EntrepriseLikee> entrepriseList=new ArrayList<EntrepriseLikee>();
		for(Object [] row:resultSet) {
			EntrepriseLikee entreprise=new EntrepriseLikee(row[0].toString(),row[1].toString(),row[2].toString());
			entrepriseList.add(entreprise);
		}
		return entrepriseList;
	}
	
	public Personne create(Personne p) {
		//Personne personneToSave=p;
		Query query=manager.createNativeQuery("INSERT INTO personnes(email,nom,prenom,telephone,pwd,is_recruteur)VALUES(?,?,?,?,?,?);");
		query.setParameter(1, p.getEmail());
		query.setParameter(2, p.getNom());
		query.setParameter(3, p.getPrenom());
		query.setParameter(4, p.getTelephone());
		query.setParameter(5, p.getPwd());
		query.setParameter(6, p.isRecruteur());
		query.executeUpdate();
		return p;
	}

}
