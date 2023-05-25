package com.produit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.jdbc.core.BeanPropertyRowMapper;


import com.produit.models.Reservation;
import com.produit.repository.ReservationRepository;
import com.produit.service.EmailService;
import com.produit.service.ReservationService;


@RestController
@CrossOrigin(origins = "http://localhost:8100",maxAge = 3600, allowCredentials="true")
@RequestMapping("/public")
public  class ReservationControllers {
	
	 private ReservationService reservationService;
	
    @Autowired
    private EmailService emailService;	
    

	@Autowired
	private ReservationRepository rr;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	  public ReservationControllers(ReservationService reservationService) {
	        this.reservationService = reservationService;
	    }
	
	@PostMapping(value="/addreservation")
	public void addUser(@RequestBody  Reservation reservation) {
		
		String query="INSERT INTO reservation (reservation_code,check_in_date,check_out_date,client_id)"
				+ "  VALUES (?,?,?,?)";
		
		jdbcTemplate.update(query,reservation.getReservationCode(),reservation.getCheckInDate(),reservation.getCheckOutDate(),reservation.getClient());
		}
	
	@PostMapping("/clients/{clientId}/image")
	public void saveClientImage(@PathVariable Long clientId, @RequestBody byte[] imageData) {
	    // Save the image to the database using the client ID
	    // You can use a framework like Spring Data JPA or Hibernate to handle the database interactions
	}
	
	
	@GetMapping("/reservationlist")
	public  List<Reservation> getreservations(){
		String query="select * from Reservation";
		return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Reservation.class));
		
}
	@GetMapping(value= "/getreservations")
	public List<Reservation> findreservations() {
		return rr.findAll();
		
	}
	
	 @GetMapping("/{email}")
	    public ResponseEntity<String> getReservationCodeByEmail(@PathVariable String email) {
	        String reservationCode = reservationService.getReservationCodeByEmail(email);
	        return ResponseEntity.ok(reservationCode);
	    }
	


 

}