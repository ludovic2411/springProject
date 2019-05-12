package com.example.demo.entities;

public class Ville {
	private String cp;
	private String nom;
	private String pays;
	public Ville(String cp, String nom, String pays) {
		super();
		this.cp = cp;
		this.nom = nom;
		this.pays = pays;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
