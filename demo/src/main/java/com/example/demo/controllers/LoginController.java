package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.LoginService;
import com.example.demo.entities.queries.Login;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	
	@PostMapping
	public Login logIn(@RequestBody Login input) {
		return service.logIn(input);
	}

}
