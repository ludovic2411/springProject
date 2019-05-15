package com.example.demo.entities.queries;

public class EntrepriseLikee {
	
	private String entreprise;
	private String nom;
	private String prenom;
	
	public EntrepriseLikee(String entreprise, String nom, String prenom) {
		super();
		this.entreprise = entreprise;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
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
	
	

}
