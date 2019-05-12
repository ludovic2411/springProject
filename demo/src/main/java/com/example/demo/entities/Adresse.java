package com.example.demo.entities;

public class Adresse {
	private int id;
	private String cp;
	private String rue;
	private String numero;
	public Adresse(int id, String cp, String rue, String numero) {
		super();
		this.id = id;
		this.cp = cp;
		this.rue = rue;
		this.numero = numero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
