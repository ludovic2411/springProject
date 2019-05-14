package com.example.demo.entities.base;

import java.time.LocalDate;

public class Destinataire {
	
	private int id;
	private int idMail;
	private String destinataire;
	private LocalDate dateEnvoi;
	private boolean lu;
	public Destinataire(int id, int idMail, String destinataire, LocalDate dateEnvoi, boolean lu) {
		super();
		this.id = id;
		this.idMail = idMail;
		this.destinataire = destinataire;
		this.dateEnvoi = dateEnvoi;
		this.lu = lu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMail() {
		return idMail;
	}
	public void setIdMail(int idMail) {
		this.idMail = idMail;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public LocalDate getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(LocalDate dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public boolean isLu() {
		return lu;
	}
	public void setLu(boolean lu) {
		this.lu = lu;
	}
	
	

}
