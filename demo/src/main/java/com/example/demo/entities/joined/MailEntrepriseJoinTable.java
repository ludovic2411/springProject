package com.example.demo.entities.joined;

public class MailEntrepriseJoinTable {
	
	private int id;
	private int entrepriseId;
	private String personneEmail;
	private int mailId;
	
	public MailEntrepriseJoinTable(int id, int entrepriseId, String personneEmail, int mailId) {
		super();
		this.id = id;
		this.entrepriseId = entrepriseId;
		this.personneEmail = personneEmail;
		this.mailId = mailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEntrepriseId() {
		return entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	public String getPersonneEmail() {
		return personneEmail;
	}

	public void setPersonneEmail(String personneEmail) {
		this.personneEmail = personneEmail;
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}
	
	

}
