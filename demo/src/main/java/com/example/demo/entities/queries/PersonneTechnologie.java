package com.example.demo.entities.queries;

public class PersonneTechnologie {
	private String technologie;
	private String domaine;
	private String nom;
	private String prenom;
	private String email;
	private Boolean isRecruteur;
	
	public PersonneTechnologie(String technologie, String domaine, String nom, String prenom, String email,
			Boolean isRecruteur) {
		super();
		this.technologie = technologie;
		this.domaine = domaine;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.isRecruteur = isRecruteur;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRecruteur() {
		return isRecruteur;
	}

	public void setRecruteur(boolean isRecruteur) {
		this.isRecruteur = isRecruteur;
	}
	
	
	
}
