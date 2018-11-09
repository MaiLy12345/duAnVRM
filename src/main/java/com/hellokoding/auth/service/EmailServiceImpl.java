package com.hellokoding.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	@Async
	public void SendMail(SimpleMailMessage mailMessage) {
		// TODO Auto-generated method stub
		mailSender.send(mailMessage);
	}

}
