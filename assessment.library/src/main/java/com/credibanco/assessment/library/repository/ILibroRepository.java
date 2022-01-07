package com.credibanco.assessment.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, String>{
	
	@Query(value = "SELECT count(a) FROM Libro a WHERE a.editorial.identifcacionEditorial = ?1")
    Integer catidad(String id);
	
	@Query(value = "SELECT l from Libro l where "
			+ "CONCAT(l.titulo, l.isbn, l.genero, l.autor) LIKE %?1%")
	public List<Libro> buscar(String tan);
	
	
	@Query(value= "select l.isbn, l.titulo, l.año, l.genero, l.numero_paginas, l.id_editorial, l.id_autor from libro l, autor a, editorial e WHERE l.id_autor= a.identificacion and l.id_editorial= e.identificacion_editorial "
			+ "and CONCAT(CONCAT((TO_CHAR(l.año,'dd-MM-yyyy')), l.genero),CONCAT( CONCAT(l.titulo, a.nombre_completo), e.nombre)) LIKE %?1%", nativeQuery = true)
	public List<Libro> filtroFinal(String filtro);

}
