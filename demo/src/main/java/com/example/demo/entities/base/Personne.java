package com.example.demo.entities.base;

public class Personne {
	
	private String email;
	private String nom;
	private String prenom;
	private long telephone;
	private String pwd;
	private boolean isRecruteur;
	
	public Personne(String email, String nom, String prenom, long telephone, String pwd, boolean isRecruteur) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.pwd = pwd;
		this.isRecruteur = isRecruteur;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isRecruteur() {
		return isRecruteur;
	}
	public void setRecruteur(boolean isRecruteur) {
		this.isRecruteur = isRecruteur;
	}
	
	

}
