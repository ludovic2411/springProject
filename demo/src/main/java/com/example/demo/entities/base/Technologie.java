package com.example.demo.entities.base;

public class Technologie {
	
	private int id;
	private String nom;
	private String domaine;
	
	public Technologie(int id, String nom, String domaine) {
		super();
		this.id = id;
		this.nom = nom;
		this.domaine = domaine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	
	

}
