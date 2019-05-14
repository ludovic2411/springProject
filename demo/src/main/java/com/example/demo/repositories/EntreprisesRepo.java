package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.*;

import com.example.demo.entities.base.Entreprise;
import com.example.demo.entities.base.Pays;

import java.util.*;

@Repository
public interface EntreprisesRepo{
	
	public Pays findAll();
	
}
