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

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.service.impl.EditorialServiceImpl;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
	
	@Autowired
	private EditorialServiceImpl serviceI;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarEditorial(@Valid @RequestBody EditorialDto obj) {
		serviceI.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<EditorialDto> listarPorId(@PathVariable String id)  {
		EditorialDto aut = serviceI.buscaPorId(id);
			return new ResponseEntity<EditorialDto>(aut, HttpStatus.OK);					
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody EditorialDto obj) {
		serviceI.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	@GetMapping("/listar")
	public  ResponseEntity<List<EditorialDto>> listarTodo() {		
		List<EditorialDto> listar = serviceI.listareditoriales();
		return new ResponseEntity<List<EditorialDto>>(listar, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable String id)  {
		serviceI.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}

}
