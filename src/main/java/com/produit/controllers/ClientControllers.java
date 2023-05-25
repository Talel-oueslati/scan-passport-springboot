package com.produit.controllers;

import com.produit.models.EmailMessage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.multipart.MultipartFile;
import com.produit.models.Client;
import com.produit.repository.ClientRepository;
import com.produit.service.EmailSenderService;

@RestController
@CrossOrigin(origins = "http://localhost:8100",maxAge = 3600, allowCredentials="true")
@RequestMapping("/public")
public class ClientControllers {
	
	
	
	
	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	
	/**	
	@Autowired
    public ClientControllers(EmailSenderService emailSenderService) {
    	this.emailSenderService = emailSenderService;
    }
    
	/**
	@Autowired
    @PostMapping(value="/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage ) {

      this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
      
      return ResponseEntity.ok("Succes");
    }
    */


	 
	
	@PostMapping(value="upload-file")
	public String uploadImage(@RequestParam("file")  MultipartFile file) throws Exception {
	
		
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		
String path_diractory="C:\\Users\\21655\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\passport_scan\\src\\main\\resources\\static";
		
		Files.copy(file.getInputStream(),Paths.get(path_diractory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		
		return "image added succesfully";	
}
	
	
	@PostMapping(value="/addclient")
	public void addUser(@RequestBody  Client client) {
		
		String query="INSERT INTO client (firstname,lastname,passport_type,nationality,gender,birth_date,passport_number,personal_number,image64,image)"
				+ "  VALUES (?,?,?,?,?,TO_DATE(?,'YY-MM-DD'),?,?,?,?)";
		SimpleDateFormat dateformat= new SimpleDateFormat("yy-MM-dd");
		String birth_date=dateformat.format(client.getBirth_date());
		
		jdbcTemplate.update(query,client.getFirstname(),client.getLastname(),client.getPassport_type(),
				client.getNationality(),client.getGender(),birth_date,client.getPassport_number(),client.getPersonal_number(),client.getImage64(),client.getImage());
		
	}

@PostMapping(value= "/addclientj")
public Client create(@RequestBody Client s1 ) {
	return cr.save(s1);
	
}
@PostMapping("/images")
public ResponseEntity<?> createImage(@RequestBody String base64Image) {
  // Decode the base64 string into a byte array
  byte[] image = Base64.getDecoder().decode(base64Image);

  // Create a new ImageEntity and set the image data
  Client client = new Client();
  client.setImage(image);

  // Save the entity in the database
  cr.save(client);

  return ResponseEntity.ok("Image saved successfully");
}
	
	@GetMapping("/clients")
	public List<Client> getUsers(){
		String query="select * from client";
		return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Client.class));
		
	}


	@PostMapping(value="/addclientt")
	public void addUser(@RequestBody Client client, @RequestParam("image") String image) {
	    String query = "INSERT INTO client (firstname,lastname,passport_type,nationality,gender,birth_date,passport_number,personal_number,image)"
	            + "  VALUES (?,?,?,?,?,?,?,?,?)";
	    jdbcTemplate.update(query, client.getFirstname(), client.getLastname(), client.getPassport_type(),
	            client.getNationality(), client.getGender(), client.getBirth_date(), client.getPassport_number(), client.getPersonal_number(), image);
	}
	
	@GetMapping(value= "/Clientsnumber")
	public long getnumbers(){
		return cr.clientsnumber();
	}
	
	@GetMapping(value= "/ClientsF")
	public long getallf(){
		return cr.findfemale();
	}
	
	
	@GetMapping(value= "/ClientsM")
	public long getallm(){
		return cr.findmale();
	}
	@GetMapping(value= "/findallp")
	public long getallp(){
		return cr.findallp();
	}
	@GetMapping(value= "/findyears")
	public long getyears(){
		return cr.findyears();
	}
	@GetMapping(value= "/findalld")
	public long getalld(){
		return cr.findalld();
	}
	@GetMapping(value= "/findalls")
	public long getalls(){
		return cr.findalls();
	}
	@DeleteMapping(value= "/deleteclient/{id}")
	void deleteclient(@PathVariable Long id) {
	cr.deleteById(id);
	}
	
	@GetMapping("/oneclient/{id}")
	public ResponseEntity<Client> getclientById(@PathVariable Long id) {
		Client client = cr.findById(id)
				.orElseThrow(()-> new ResourceAccessException("client not exist with id:" + id));
			return ResponseEntity.ok(client);
	}
	//update clientserver
	@PutMapping("/updateclient/{id}")
	public ResponseEntity<Client> updatechampion(@PathVariable Long id,@RequestBody Client clientnew) {
		Client  Client = cr.findById(id)
				.orElseThrow(()-> new ResourceAccessException("client not exist with id:" + id));
		 Client.setPassport_type(clientnew.getPassport_type());
		 Client.setFirstname(clientnew.getFirstname());
		 Client.setLastname(clientnew.getLastname());
		 Client.setPassport_number(clientnew.getPassport_number());
		 Client.setNationality(clientnew.getNationality());
		 Client.setBirth_date(clientnew.getBirth_date());
		 Client.setGender(clientnew.getGender());
		 Client.setPersonal_number(clientnew.getPersonal_number());
		 Client.setImage64(clientnew.getImage64());


		
		
		Client updatedclient = cr.save(Client);
		return ResponseEntity.ok(updatedclient);
	}
}
