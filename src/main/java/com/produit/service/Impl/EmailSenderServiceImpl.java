/**package com.produit.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.produit.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	
	@Autowired
	private JavaMailSender mailSender;
	

	
	public EmailSenderServiceImpl(JavaMailSender mailSender) {
		 this.mailSender=mailSender;
	}




	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("yonkoshanks11@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		
		this.mailSender.send(simpleMailMessage);
		
		
	}

}
*/
