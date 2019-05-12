package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.*;
import com.example.demo.entities.Entreprise;
import com.example.demo.entities.Pays;

import java.util.*;

@Repository
public interface EntreprisesRepo{
	
	public Pays findAll();
	
}
