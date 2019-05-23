package com.example.demo.entities.queries;

public class EntrepriseLikee {
	
	private String entreprise;
	private String nom;
	private String prenom;
	private int entrepriseId;
	private int favoriteId;
	
	public EntrepriseLikee(String entreprise, String nom, String prenom,int entrepriseId,int favoriteId) {
		super();
		this.entreprise = entreprise;
		this.nom = nom;
		this.prenom = prenom;
		this.entrepriseId=entrepriseId;
		this.favoriteId=favoriteId;
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

	public int getEntrepriseId() {
		return entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	
	

}
