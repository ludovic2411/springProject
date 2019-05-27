package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.mail.SimpleMailMessage;

@Component
public class EmailServiceImpl   {
	
	@Autowired
    public JavaMailSender emailSender;
	
	public void sendRegister(String to,String text,String subject) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("teal@stackApply.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	
}
