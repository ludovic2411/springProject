package com.example.demo.dal.entities;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name="pays")
public class Pays {
	@Id
	@Size(min=3,max=3)
	@Column(nullable=false)
	private String code;

	public Pays(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
