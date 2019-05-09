package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Greeting;

@RestController
@RequestMapping("")
public class GreetingController {
	@GetMapping("/hello")
	public Greeting greet(@RequestParam("message")String message){
		return new Greeting(message);
	}
}
