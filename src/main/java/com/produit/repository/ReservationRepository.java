package com.produit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produit.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	  
	  Optional<Reservation> findByEmail(String email);
	  
	  
}
