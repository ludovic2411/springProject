package com.example.demo.dal.entities;
import javax.persistence.*;
import javax.validation.constraints.Size;


public class Pays {
	
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
