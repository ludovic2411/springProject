package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Entreprise;
import com.example.demo.dal.repositories.EntreprisesRepo;


@Service
public class EntreprisesService{
	@Autowired
	private EntreprisesRepo repo;
	
	
	public List<Entreprise> findAll(){
		return repo.findAll();
	}

}
