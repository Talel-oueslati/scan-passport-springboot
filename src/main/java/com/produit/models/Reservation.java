package com.produit.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservation_id;
	
	@Column(name ="reservationcode")
	private String reservationCode;
	
	@Column(name ="check_in_date")
	private Date checkInDate;
	
	@Column(name ="check_out_date")
	private Date checkOutDate;
	
	private  String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Client client;

	public Reservation() {
		super();
	}

	public Reservation(Long reservation_id, String reservationCode, Date checkInDate, Date checkOutDate, String email,
			Client client) {
		super();
		this.reservation_id = reservation_id;
		this.reservationCode = reservationCode;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.email = email;
		this.client = client;
	}

	/**
	 * @return the reservation_id
	 */
	public Long getReservation_id() {
		return reservation_id;
	}

	/**
	 * @param reservation_id the reservation_id to set
	 */
	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}

	/**
	 * @return the reservationCode
	 */
	public String getReservationCode() {
		return reservationCode;
	}

	/**
	 * @param reservationCode the reservationCode to set
	 */
	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	/**
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
