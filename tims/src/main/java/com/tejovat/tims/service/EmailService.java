package com.tejovat.tims.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	
	public void sendEmail(SimpleMailMessage email);
	public void sendEmailHtml(String htmlContains, String email, String subject);
	
}

