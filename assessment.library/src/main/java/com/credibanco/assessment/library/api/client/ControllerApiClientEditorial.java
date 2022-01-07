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
import com.credibanco.assessment.library.dto.EditorialDto;

@RestController
@RequestMapping("/clienteEdi")
public class ControllerApiClientEditorial {
	

	private String LISTAR_ALL_EDITORIAL_="http://localhost:8080/editoriales/listar";
	private String GUARDAR_EDITORIAL="http://localhost:8080/editoriales/guardar";
	private String ELIMINAR_EDITORIAL="http://localhost:8080/editoriales/eliminar/{id}";
	private String EDITAR_EDITORIAL="http://localhost:8080/editoriales/editar";
	RestTemplate resTemplate = new RestTemplate();
	
	@GetMapping("/listar")
	public  ResponseEntity<List<EditorialDto>> listarTodo() {	
		
		
		EditorialDto[] dtoList = resTemplate.getForObject(LISTAR_ALL_EDITORIAL_, EditorialDto[].class);
		
		return new ResponseEntity<List<EditorialDto>>(Arrays.asList(dtoList), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarAutor(@Valid @RequestBody EditorialDto obj) {
		
		resTemplate.postForEntity(GUARDAR_EDITORIAL, obj, EditorialDto.class);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable String id)  {
		resTemplate.delete(ELIMINAR_EDITORIAL, id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody AutorDto obj) {
		resTemplate.put(EDITAR_EDITORIAL, obj, obj.getIdentificacion());
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}


}
