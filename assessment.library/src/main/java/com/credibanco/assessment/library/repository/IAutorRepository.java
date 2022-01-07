package com.credibanco.assessment.library.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, String>{
	
	@Query(value = "SELECT count(a) FROM Autor a WHERE a.identificacion = ?1")
    BigInteger validarExistenciaPorIdAutor(Integer id);
	

}
