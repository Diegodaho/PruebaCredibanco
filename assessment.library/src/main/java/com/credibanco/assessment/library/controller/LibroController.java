package com.credibanco.assessment.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.LibroDto;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.service.impl.LibroServiceImpl;

@RestController
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private LibroServiceImpl serviceI;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarLibro(@Valid @RequestBody LibroDto obj) {
		serviceI.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<LibroDto>> listarNuevoTodo() {		
		List<LibroDto> listar = serviceI.ListarLibrosCorrecto();
		return new ResponseEntity<List<LibroDto>>(listar, HttpStatus.OK);
	}
	@GetMapping("/listarPoFiltro/{id}")
	public  ResponseEntity<List<LibroDto>> listarNuevoTodoCleintApi(@PathVariable String id) {		
		List<LibroDto> listar = serviceI.ListarCleintApi(id);
		return new ResponseEntity<List<LibroDto>>(listar, HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Libro> eliminar(@PathVariable String id)  {
		serviceI.eliminar(id);
			return new ResponseEntity<Libro>(HttpStatus.NO_CONTENT);					
	}

	
	

}
