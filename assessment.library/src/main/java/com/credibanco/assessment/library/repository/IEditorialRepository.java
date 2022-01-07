package com.credibanco.assessment.library.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Editorial;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, String>{
	
	boolean existsByNombre(String nombreEditorial);
	
	@Query(value = "SELECT count(a) FROM Editorial a WHERE a.identifcacionEditorial = ?1")
    BigInteger validarExistenciaPorIdEditorial(Integer id);
	
	@Query(value = "SELECT a.maximoLibrosRegistrados FROM Editorial a WHERE a.identifcacionEditorial = ?1")
	Integer librosMaximos (String id);
	
	

}
