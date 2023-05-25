package com.produit.models;

import java.sql.Blob;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String passport_type;
		
		private String firstname;
		
		private String lastname;
		
		private String passport_number;
		
		private String nationality;
		
		
		
		@Column(name="birth_date")
		@DateTimeFormat(pattern = "yy-MM-dd")
		private Date birth_date;
		
		private String gender;
		
		private String personal_number;
		
	    @Lob
	    @Column(name = "IMAGE64", columnDefinition = "CLOB")
	    private String image64;
		
	    @Lob
	    @Column(name = "image")
	    private byte[] image;

		public Client() {
			super();
		}

		public Client(Long id, String passport_type, String firstname, String lastname, String passport_number,
				String nationality, Date birth_date, String gender, String personal_number, String image64,
				byte[] image) {
			super();
			this.id = id;
			this.passport_type = passport_type;
			this.firstname = firstname;
			this.lastname = lastname;
			this.passport_number = passport_number;
			this.nationality = nationality;
			this.birth_date = birth_date;
			this.gender = gender;
			this.personal_number = personal_number;
			this.image64 = image64;
			this.image = image;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the passport_type
		 */
		public String getPassport_type() {
			return passport_type;
		}

		/**
		 * @param passport_type the passport_type to set
		 */
		public void setPassport_type(String passport_type) {
			this.passport_type = passport_type;
		}

		/**
		 * @return the firstname
		 */
		public String getFirstname() {
			return firstname;
		}

		/**
		 * @param firstname the firstname to set
		 */
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		/**
		 * @return the lastname
		 */
		public String getLastname() {
			return lastname;
		}

		/**
		 * @param lastname the lastname to set
		 */
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		/**
		 * @return the passport_number
		 */
		public String getPassport_number() {
			return passport_number;
		}

		/**
		 * @param passport_number the passport_number to set
		 */
		public void setPassport_number(String passport_number) {
			this.passport_number = passport_number;
		}

		/**
		 * @return the nationality
		 */
		public String getNationality() {
			return nationality;
		}

		/**
		 * @param nationality the nationality to set
		 */
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		/**
		 * @return the birth_date
		 */
		public Date getBirth_date() {
			return birth_date;
		}

		/**
		 * @param birth_date the birth_date to set
		 */
		public void setBirth_date(Date birth_date) {
			this.birth_date = birth_date;
		}

		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}

		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}

		/**
		 * @return the personal_number
		 */
		public String getPersonal_number() {
			return personal_number;
		}

		/**
		 * @param personal_number the personal_number to set
		 */
		public void setPersonal_number(String personal_number) {
			this.personal_number = personal_number;
		}

		/**
		 * @return the image64
		 */
		public String getImage64() {
			return image64;
		}

		/**
		 * @param image64 the image64 to set
		 */
		public void setImage64(String image64) {
			this.image64 = image64;
		}

		/**
		 * @return the image
		 */
		public byte[] getImage() {
			return image;
		}

		/**
		 * @param image the image to set
		 */
		public void setImage(byte[] image) {
			this.image = image;
		}
	    
		
	    

}
