package com.example.demo.entities.joined;

public class TechnologieEntrepriseJoinTable {
	
	private int id;
	private int entrepriseid;
	private int technologieId;
	
	public TechnologieEntrepriseJoinTable(int id, int entrepriseid, int technologieId) {
		super();
		this.id = id;
		this.entrepriseid = entrepriseid;
		this.technologieId = technologieId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEntrepriseid() {
		return entrepriseid;
	}

	public void setEntrepriseid(int entrepriseid) {
		this.entrepriseid = entrepriseid;
	}

	public int getTechnologieId() {
		return technologieId;
	}

	public void setTechnologieId(int technologieId) {
		this.technologieId = technologieId;
	}
	
	

}
