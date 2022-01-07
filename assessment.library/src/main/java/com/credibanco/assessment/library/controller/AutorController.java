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

import com.credibanco.assessment.library.dto.AutorDto;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.service.impl.AutorServiceImpl;


@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorServiceImpl serviceI;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarAutor(@Valid @RequestBody AutorDto obj) {
		serviceI.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<AutorDto> listarPorId(@PathVariable String id)  {
		AutorDto aut = serviceI.buscaPorId(id);
			return new ResponseEntity<AutorDto>(aut, HttpStatus.OK);					
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody AutorDto obj) {
		serviceI.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	@GetMapping("/listar")
	public  ResponseEntity<List<AutorDto>> listarTodo() {		
		List<AutorDto> listar = serviceI.listarAutores();
		return new ResponseEntity<List<AutorDto>>(listar, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable String id)  {
		serviceI.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}

}
