package com.example.demo.services;


import com.example.demo.entities.queries.EntrepriseDetail;
import com.example.demo.entities.queries.EntrepriseTechnologie;
import com.example.demo.entities.queries.EntrepriseToInsert;

import org.springframework.stereotype.Service;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import java.util.*;

@Service
public class EntreprisesService {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private boolean checkVille(String cp) {
		boolean exist=false;
		Query query=entityManager.createNativeQuery("SELECT cp from adresses WHERE cp=?");
		query.setParameter(1, cp);
		List<Object []> resultSet=query.getResultList();
		if(!resultSet.isEmpty()) {
			exist=true;
		}
		return exist;
	}
	
	public long getLastAdresseId() {
		Query query=entityManager.createNativeQuery("SELECT MAX(id) FROM adresses");
		long previousId=Long.parseLong(query.getSingleResult().toString());
		return previousId;
	}
	
	public long getLastEntrepriseId() {
		Query countE=entityManager.createNativeQuery("SELECT MAX(id) FROM entreprises");
		long previousEntId=Long.parseLong(countE.getSingleResult().toString());
		return previousEntId;
	}
	
	public List<EntrepriseDetail> getAll() {
	
		Query query=entityManager.createNativeQuery("SELECT e.nom,e.site_web,e.mail, a.cp, a.rue,a.numero,v.nom AS ville,e.id AS entrepriseId FROM entreprises AS e INNER JOIN adresses AS a ON e.adresse=a.id INNER JOIN villes AS v on a.cp=v.cp;");
		List<Object[]> resultList=query.getResultList();
		List<EntrepriseDetail> entreprisesList=new ArrayList<EntrepriseDetail>();
		for(Object[] row:resultList) {
			//System.out.println(row[0].toString()+" "+row[1].toString()+" "+row[2].toString()+" "+row[3].toString()+" "+
					 //row[4].toString()+" "+row[5].toString()+" "+row[6].toString()+" "+Integer.parseInt(row[7].toString()));
			
			EntrepriseDetail entreprise=new EntrepriseDetail(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),
			 row[4].toString(),row[5].toString(),row[6].toString(),Integer.parseInt(row[7].toString()));
			 entreprisesList.add(entreprise);
		}
		return entreprisesList;
	}
	
	public EntrepriseDetail getById(int id) {
		EntrepriseDetail result=null;
		Query query=entityManager.createNativeQuery("SELECT e.nom,e.site_web,e.mail, a.cp, a.rue,a.numero,v.nom AS ville, e.id AS entrepriseId FROM entreprises AS e INNER JOIN adresses AS a ON e.adresse=a.id INNER JOIN villes AS v on a.cp=v.cp WHERE e.id=?");
		query.setParameter(1, id);
		List <Object[]>  resultSet=query.getResultList();
		List <EntrepriseDetail> entrepriseList=new ArrayList<EntrepriseDetail>();
		for(Object [] row: resultSet) {
			EntrepriseDetail entreprise=new EntrepriseDetail(row[0].toString(),row[1].toString(),row[2].toString(),row[3].toString(),
					 row[4].toString(),row[5].toString(),row[6].toString(),Integer.parseInt(row[7].toString()));
			entrepriseList.add(entreprise);
		}
		if(!entrepriseList.isEmpty()) {
			result=entrepriseList.get(0);
		}
		return result;
	}
	
	//Retourne une liste d'entreprises avec les technologies utilisées
	public List<EntrepriseTechnologie> getByTechnologie(){
		
		Query query=entityManager.createNativeQuery("SELECT t.nom AS technologie, t.domaine, e.nom AS entreprise FROM entreprises AS e INNER JOIN technologies_entreprises_join_table AS v ON e.id=v.entreprise_id INNER JOIN technologies AS t ON v.technologie_id=t.id;");
		List<Object[]> resultList=query.getResultList();
		List<EntrepriseTechnologie> entreprisesTechnoList=new ArrayList<EntrepriseTechnologie>();
		
		for(Object[] row:resultList) {
			EntrepriseTechnologie entreprise= new EntrepriseTechnologie(row[0].toString(),row[1].toString(),row[2].toString());
			entreprisesTechnoList.add(entreprise);
		}
		return entreprisesTechnoList;
	}
	
	public EntrepriseToInsert create(EntrepriseToInsert e) {
		//System.out.println(e.getCp()+" "+e.getMail()+" "+e.getNomEntreprise()+" "+e.getNomVille()+" "+e.getNumero()+" "+e.getPays()+" "+e.getRue()
		//+" "+e.getSite());
		System.out.println(this.checkVille(e.getCp()));
		//System.out.println(e);
		//Calcul de l'id des adresses
		long previousId=this.getLastAdresseId();
		//Calcul de l'id de l'entreprise
		long previousEntId=this.getLastEntrepriseId();
		//insertion de la ville
		if(!this.checkVille(e.getCp())) {
			Query createVille=entityManager.createNativeQuery("INSERT INTO villes(cp,nom,pays) VALUES (?,?,?);");
			createVille.setParameter(1, e.getCp());
			createVille.setParameter(2, e.getNomVille());
			createVille.setParameter(3, e.getPays());
			createVille.executeUpdate();
			//insertion de l'adresse
			Query createAdresse=entityManager.createNativeQuery("INSERT INTO adresses(id,cp,rue,numero) VALUES(?,?,?,?);");
			createAdresse.setParameter(1, previousId+1);
			createAdresse.setParameter(2, e.getCp());
			createAdresse.setParameter(3, e.getRue());
			createAdresse.setParameter(4, e.getNumero());
			createAdresse.executeUpdate();
			//insertion de l'entreprise
			Query createEntreprise=entityManager.createNativeQuery("INSERT INTO entreprises(id,nom,adresse,site_web,telephone, mail) VALUES(?,?,?,?,?,?);");
			createEntreprise.setParameter(1, previousEntId+1);
			createEntreprise.setParameter(2, e.getNomEntreprise());
			createEntreprise.setParameter(3, previousId+1);
			createEntreprise.setParameter(4,e.getSite());
			createEntreprise.setParameter(5, e.getTelephone());
			createEntreprise.setParameter(6, e.getMail());
			createEntreprise.executeUpdate();
		}else {
			//insertion de l'adresse
			Query createAdresse=entityManager.createNativeQuery("INSERT INTO adresses(id,cp,rue,numero) VALUES(?,?,?,?);");
			createAdresse.setParameter(1, previousId+1);
			createAdresse.setParameter(2, e.getCp());
			createAdresse.setParameter(3, e.getRue());
			createAdresse.setParameter(4, e.getNumero());
			createAdresse.executeUpdate();
			//insertion de l'entreprise
			Query createEntreprise=entityManager.createNativeQuery("INSERT INTO entreprises(id,nom,adresse,site_web,telephone, mail) VALUES(?,?,?,?,?,?);");
			createEntreprise.setParameter(1, previousEntId+1);
			createEntreprise.setParameter(2, e.getNomEntreprise());
			createEntreprise.setParameter(3, previousId+1);
			createEntreprise.setParameter(4,e.getSite());
			createEntreprise.setParameter(5, e.getTelephone());
			createEntreprise.setParameter(6, e.getMail());
			createEntreprise.executeUpdate();
		}
		
		
		return e;
	}
}  
