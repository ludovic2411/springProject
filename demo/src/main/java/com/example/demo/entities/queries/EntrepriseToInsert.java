package com.example.demo.entities.queries;

import com.example.demo.entities.base.Adresse;

public class EntrepriseToInsert {
	
	private String nomEntreprise;
	private String cp;
	private String rue;
	private String numero;
	private String nomVille;
	private String pays;
	private String site;
	private Long telephone;
	private String mail;
	
	public EntrepriseToInsert(String nomEntreprise, String cp, String rue, String numero,
			String nomVille, String pays,String site, Long telephone,String mail) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.cp = cp;
		this.rue = rue;
		this.numero = numero;
		this.nomVille = nomVille;
		this.pays = pays;
		this.site=site;
		this.telephone=telephone;
		this.mail=mail;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
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

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	

}
