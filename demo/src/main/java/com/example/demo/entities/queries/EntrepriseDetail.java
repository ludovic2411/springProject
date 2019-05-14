package com.example.demo.entities.queries;

public class EntrepriseDetail { 
	
	private String nom;
	private String siteWeb;
	private String email;
	private String cp;
	private String rue;
	private String numero;
	private String ville;
	
	public EntrepriseDetail(String nom, String siteWeb, String email, String cp, String rue, String numero,
			String ville) {
		super();
		this.nom = nom;
		this.siteWeb = siteWeb;
		this.email = email;
		this.cp = cp;
		this.rue = rue;
		this.numero = numero;
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
