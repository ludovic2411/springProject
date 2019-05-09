package com.example.demo.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Ville {
	
	@Id
	@Column(nullable=false)
	private String cp;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
	@Size(min=3,max=3)
	@OneToOne
	@JoinColumn(name="pays")
	private Pays pays;

	public Ville(String cp, String nom, @Size(min = 3, max = 3) Pays pays) {
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

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	
}
