package com.produit.service;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.SimpleMailMessage;



@Service
public class EmailService {


    private JavaMailSenderImpl mailSender;

    public void sendReservationCodeEmail(String to, List<String> reservationCodes) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your reservation code(s)");
        message.setText("Your reservation code(s): " + String.join(", ", reservationCodes));
        mailSender.send(message);
    }
}
