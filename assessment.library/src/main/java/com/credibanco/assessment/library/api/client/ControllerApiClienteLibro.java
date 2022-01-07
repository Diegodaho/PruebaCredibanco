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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.credibanco.assessment.library.dto.AutorDto;
import com.credibanco.assessment.library.dto.LibroDto;

@RestController
@RequestMapping("/clienteLib")
public class ControllerApiClienteLibro {
	
	private String LISTAR_ALL_LIBRO_="http://localhost:8080/libros/listar";
	private String GUARDAR_LIBRO="http://localhost:8080/libros/guardar";
	private String ELIMINAR_LIBRO="http://localhost:8080/libros/eliminar/{id}";
	private String EDITAR_LIBRO="http://localhost:8080/libros/listarPoFiltro/";
	
	RestTemplate resTemplate = new RestTemplate();
	
	@GetMapping("/listar")
	public  ResponseEntity<List<LibroDto>> listarTodo() {	
		
		
		LibroDto[] dtoList = resTemplate.getForObject(LISTAR_ALL_LIBRO_, LibroDto[].class);
		
		return new ResponseEntity<List<LibroDto>>(Arrays.asList(dtoList), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody LibroDto obj) {
		
		resTemplate.postForEntity(GUARDAR_LIBRO, obj, AutorDto.class);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listarPoFiltro/{id}")
	public  ResponseEntity<List<LibroDto>> listarNuevoTodoCleintApi(@PathVariable String id)
	{	
		LibroDto[] dtoList = resTemplate.getForObject(EDITAR_LIBRO + id, LibroDto[].class);
		
		return new ResponseEntity<List<LibroDto>>(Arrays.asList(dtoList), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable String id)  {
		resTemplate.delete(ELIMINAR_LIBRO, id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);					
	}

}
