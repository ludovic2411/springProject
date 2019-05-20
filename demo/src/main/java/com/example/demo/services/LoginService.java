package com.example.demo.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entities.queries.Login;

@Service
public class LoginService {
	@PersistenceContext		
	private EntityManager em;
	
	public Login logIn(Login input) {
		
		Login authdUser=null;
		
		Query query=em.createNativeQuery("SELECT p.email,p.pwd FROM personnes AS p WHERE p.email=? AND p.pwd=?;");
		query.setParameter(1, input.getEmail());
		query.setParameter(2, input.getPwd());
		
		List<Object []> resultSet=query.getResultList();
		List<Login> loginList=new ArrayList <Login>();
		
		if(!resultSet.isEmpty()) {
			for(Object [] row:resultSet) {
				Login login=new Login(row[0].toString(),row[1].toString());
				loginList.add(login);
			}
			authdUser=loginList.get(0);
		}
		return authdUser;
	}

}
