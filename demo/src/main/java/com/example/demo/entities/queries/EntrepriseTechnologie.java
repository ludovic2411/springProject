package com.example.demo.entities.queries;

public class EntrepriseTechnologie {
	
	private String technologie;
	private String domaine;
	private String entreprise;
	
	public EntrepriseTechnologie(String technologie, String domaine, String entreprise) {
		super();
		this.technologie = technologie;
		this.domaine = domaine;
		this.entreprise = entreprise;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	
	
}
