package com.example.demo.dal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.dal.entities.Entreprise;

@Repository
public interface EntreprisesRepo {
	
	@Query(value="SELECT e.nom,e.site_web,e.mail, a.cp, a.rue,a.numero,v.nom  FROM entreprises+"
			+ " AS e INNER JOIN adresses AS a ON e.adresse=a.id "+
			"INNER JOIN villes AS v on a.cp=v.cp;",nativeQuery=true)
	public List<Entreprise> findAll();

}
