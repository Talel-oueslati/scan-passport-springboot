package com.produit.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.produit.models.Reservation;
import com.produit.models.User;
import com.produit.repository.ReservationRepository;
import com.produit.repository.UserRepository;



@Service
public class ReservationService {
	
	  private  UserRepository userRepository;
	  private  ReservationRepository reservationRepository;

	  public ReservationService(UserRepository userRepository, ReservationRepository reservationRepository) {
	        this.userRepository = userRepository;
	        this.reservationRepository = reservationRepository;
	    }
	  public String getReservationCodeByEmail(String email) {
	        Optional<User> userOptional = userRepository.findByEmail(email);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            return reservationRepository.findByEmail(user.getEmail())
	                    .map(Reservation::getReservationCode)
	                    .orElse("No reservation found for the user.");
	        } else {
	            return "User not found.";
	        }
	    }
}
