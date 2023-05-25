package com.produit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.produit.models.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	
	@Query(value="SELECT COUNT(*) FROM client WHERE gender='F'",nativeQuery = true)
	public long  findfemale();
	
	@Query(value="SELECT COUNT(*) FROM client WHERE gender='M'",nativeQuery = true)
	public long  findmale();
	
	@Query(value="	SELECT FLOOR(DATEDIFF(NOW(), birth_date) / 365) AS age, COUNT(*) AS count\r\n"
			+ "	FROM client\r\n"
			+ "	GROUP BY age\r\n"
			+ "	ORDER BY age ASC;",nativeQuery = true)
	public long  findyears();

	
	@Query(value="SELECT COUNT(*) FROM client WHERE passport_type='P'",nativeQuery = true)
	public long  findallp();

	@Query(value="SELECT COUNT(*) FROM client WHERE passport_type='D'",nativeQuery = true)
	public long  findalld();
	
	@Query(value="SELECT COUNT(*) FROM client WHERE passport_type='S'",nativeQuery = true)
	public long  findalls();
	
	@Query(value="SELECT COUNT(*) FROM client ",nativeQuery = true)
	public long  clientsnumber();
	

	
	

	
}
