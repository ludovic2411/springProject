package com.example.demo.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity(name="adresses")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	@OneToOne
	@JoinColumn(name="cp")
	private Ville ville;
	
	@Column(nullable=false)
	@Size(max=255)
	private String rue;
	
	@Column(nullable=false)
	private String numero;

	public Adresse(int id, Ville ville, @Size(max = 255) String rue, String numero) {
		super();
		this.id = id;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
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
	
	
}
