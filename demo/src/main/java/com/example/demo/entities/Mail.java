package com.example.demo.entities;

public class Mail {
	
	private int id;
	private String expediteur;
	private String message;
	private boolean isCandidature;
	
	public Mail(int id, String expediteur, String message, boolean isCandidature) {
		super();
		this.id = id;
		this.expediteur = expediteur;
		this.message = message;
		this.isCandidature = isCandidature;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isCandidature() {
		return isCandidature;
	}

	public void setCandidature(boolean isCandidature) {
		this.isCandidature = isCandidature;
	}
	
	
	

}
