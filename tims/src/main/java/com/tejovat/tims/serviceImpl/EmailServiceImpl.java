package com.tejovat.tims.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tejovat.tims.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);
	}

	@Override
	public void sendEmailHtml(String htmlContains, String email, String subject) {
		try {
			MimeMessage mimemessage=mailSender.createMimeMessage();
			MimeMessageHelper mimeMessHelp=new MimeMessageHelper(mimemessage,true);
			mimemessage.setContent(htmlContains.trim(), "text/html");
			mimeMessHelp.setFrom("noreply@mjbtech.com");
			mimeMessHelp.setTo(email);
			mimeMessHelp.setSubject(subject);
			mailSender.send(mimemessage);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
