package com.hellokoding.auth.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	public void SendMail(SimpleMailMessage mailMessage);
}
