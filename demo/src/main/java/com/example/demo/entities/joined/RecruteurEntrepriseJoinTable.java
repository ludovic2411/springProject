package com.example.demo.entities.joined;

public class RecruteurEntrepriseJoinTable {
	
	private int id;
	private String recruteurEmail;
	private int entrepriseId;
	
	public RecruteurEntrepriseJoinTable(int id, String recruteurEmail, int entrepriseId) {
		super();
		this.id = id;
		this.recruteurEmail = recruteurEmail;
		this.entrepriseId = entrepriseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecruteurEmail() {
		return recruteurEmail;
	}

	public void setRecruteurEmail(String recruteurEmail) {
		this.recruteurEmail = recruteurEmail;
	}

	public int getEntrepriseId() {
		return entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}
	
	
}
