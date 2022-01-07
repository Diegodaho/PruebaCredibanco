package com.credibanco.assessment.library.proyect2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.credibanco.assessment.library.proyect2.api.client.exceptions.ModelNotFoundException;
import com.credibanco.assessment.library.proyect2.dto.LibroDto;
import com.credibanco.assessment.library.proyect2.service.impl.LibroDtoServiceImpl;

@Service
public class LibroDtoService implements LibroDtoServiceImpl{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<LibroDto> ListarCleintApi(String calro) {
		
		
		LibroDto[] libro = restTemplate.getForObject("http://localhost:8080/libros/listarPoFiltro/" + calro, LibroDto[].class);
		
		
		if(libro.length==0) {
			
			throw new ModelNotFoundException("No se encontraron libros dentro del registro con lo anterior escrito. -"
					+ "->("+calro+") ");
			
		}
	
		return Arrays.asList(libro);
	}

	@Override
	public List<LibroDto> ListarClein() {
		
		LibroDto[] libro = restTemplate.getForObject("http://localhost:8080/libros/listarNuevo", LibroDto[].class);
		
		
		return Arrays.asList(libro);
	}
	
	

}
