package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.base.Personne;
import com.example.demo.entities.joined.RecruteurEntrepriseJoinTable;
import com.example.demo.entities.queries.EntrepriseLikee;
import com.example.demo.entities.queries.PersonneTechnologie;

@Service
public class PersonneService {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	EmailServiceImpl mailer;
	
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
		Query query=manager.createNativeQuery("SELECT e.nom AS entreprise_likee, p.nom, p.prenom, e.id as entrepriseId, j.id as favoriteId  FROM recruteur_entreprise_join_table AS j INNER JOIN entreprises AS e ON e.id=j.entreprise_id INNER JOIN personnes AS p on p.email=j.recruteur_email WHERE p.email=? AND p.is_recruteur=0;");
		query.setParameter(1, email);
		List<Object[]> resultSet=query.getResultList();
		List<EntrepriseLikee> entrepriseList=new ArrayList<EntrepriseLikee>();
		for(Object [] row:resultSet) {
			EntrepriseLikee entreprise=new EntrepriseLikee(row[0].toString(),row[1].toString(),row[2].toString(),Integer.parseInt(row[3].toString()),Integer.parseInt(row[4].toString()));
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
		this.mailer.sendRegister("f4c41f6920-92df21@inbox.mailtrap.io","Bienvenue sur StackApply, "+p.getNom()+" "+p.getPrenom()+".\n Votre email: "+p.getEmail(),"Votre inscription sur StackApply");
		return p;
	}
	
	//Insére une entreprise dans la table des entreprises likee et retourne une entreprise likee
	public List<EntrepriseLikee> createFavorite(RecruteurEntrepriseJoinTable e,String email) {
		//Prend l'id de la dernière entreprise ajoutée
		Query query=manager.createNativeQuery("SELECT COUNT(*) FROM recruteur_entreprise_join_table");
		long previousId=Long.parseLong(query.getSingleResult().toString());
		//Insère dans la liste des favoris
		Query insertQuery=manager.createNativeQuery("INSERT INTO recruteur_entreprise_join_table(recruteur_email,entreprise_id) VALUES(?,?);");
		insertQuery.setParameter(1, e.getRecruteurEmail());
		insertQuery.setParameter(2,e.getEntrepriseId());
		insertQuery.executeUpdate();
		//affiche l'entreprise ajoutée
		Query displayQuery=manager.createNativeQuery("SELECT e.nom AS entreprise_likee, p.nom, p.prenom, e.id AS entrepriseId, j.id AS favoriteId  FROM recruteur_entreprise_join_table AS j INNER JOIN entreprises AS e ON e.id=j.entreprise_id INNER JOIN personnes AS p on p.email=j.recruteur_email WHERE p.email=? AND p.is_recruteur=0;");
		displayQuery.setParameter(1, email);
		List<Object[]> resultSet=displayQuery.getResultList();
		List<EntrepriseLikee> entrepriseList=new ArrayList<EntrepriseLikee>();
		for(Object [] row:resultSet) {
			EntrepriseLikee entreprise=new EntrepriseLikee(row[0].toString(),row[1].toString(),row[2].toString(),Integer.parseInt(row[3].toString()),Integer.parseInt(row[4].toString()));
			entrepriseList.add(entreprise);
		}
		
		return entrepriseList;
	}
	//supprime une entreprise des favoris
	public boolean deleteFavorite(int id){
		Query query=manager.createNativeQuery("DELETE FROM recruteur_entreprise_join_table WHERE id=?;");
		query.setParameter(1, id);
		query.executeUpdate();
		
		return true;
	}

}
