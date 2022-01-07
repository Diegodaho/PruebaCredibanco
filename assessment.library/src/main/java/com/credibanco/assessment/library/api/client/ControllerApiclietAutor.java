package com.credibanco.assessment.library.api.client;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.client.RestTemplate;

import com.credibanco.assessment.library.dto.AutorDto;

@RestController
@RequestMapping("/clienteAut")
public class ControllerApiclietAutor {
	
	private String LISTAR_TODOS_LOS_AUTORES="http://localhost:8080/autores/listar";
	private String GUARDAR_AUTOR="http://localhost:8080/autores/guardar";
	private String ELIMINAR_AUTOR="http://localhost:8080/autores/eliminar/{id}";
	private String EDITAR_AUTOR="http://localhost:8080/autores/editar";
	RestTemplate resTemplate = new RestTemplate();
	
	@GetMapping("/listar")
	public  ResponseEntity<List<AutorDto>> listarTodo() {	
		
		
		AutorDto[] dtoList = resTemplate.getForObject(LISTAR_TODOS_LOS_AUTORES, AutorDto[].class);
		
		return new ResponseEntity<List<AutorDto>>(Arrays.asList(dtoList), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarAutor(@Valid @RequestBody AutorDto obj) {
		
		resTemplate.postForEntity(GUARDAR_AUTOR, obj, AutorDto.class);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable String id)  {
		resTemplate.delete(ELIMINAR_AUTOR, id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody AutorDto obj) {
		resTemplate.put(EDITAR_AUTOR, obj, obj.getIdentificacion());
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}

}
