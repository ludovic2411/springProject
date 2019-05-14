package com.example.demo.entities.joined;

public class TechnologiePersonneJoinTable {

	private int id;
	private int technologieId;
	private String personneEmail;
	
	public TechnologiePersonneJoinTable(int id, int technologieId, String personneEmail) {
		super();
		this.id = id;
		this.technologieId = technologieId;
		this.personneEmail = personneEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTechnologieId() {
		return technologieId;
	}

	public void setTechnologieId(int technologieId) {
		this.technologieId = technologieId;
	}

	public String getPersonneEmail() {
		return personneEmail;
	}

	public void setPersonneEmail(String personneEmail) {
		this.personneEmail = personneEmail;
	}
	
	
}
