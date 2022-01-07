package com.credibanco.assessment.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dto.AutorDto;
import com.credibanco.assessment.library.exceptions.ArgumentRequiredException;
import com.credibanco.assessment.library.exceptions.BusinessLogicException;
import com.credibanco.assessment.library.exceptions.ModelNotFoundException;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.repository.IAutorRepository;
import com.credibanco.assessment.library.service.impl.AutorServiceImpl;


@Service
public class AutorService implements AutorServiceImpl {
	
	@Autowired
	private IAutorRepository repoAutor;

	@Override
	public void guardar(AutorDto clase) {
		boolean exist=repoAutor.existsById(clase.getIdentificacion());
		
		if(exist==true) {
			throw new BusinessLogicException("El Autor ya existe");
		}
		
		Autor autor = new Autor();
		
		autor.setIdentificacion(clase.getIdentificacion());
		autor.setNombreCompleto(clase.getNombreCompleto());
		autor.setFechaNacimiento(clase.getFechaNacimiento());
		autor.setCiudadProcedencia(clase.getCiudadProcedencia());
		autor.setCorreoElectrinico(clase.getCorreoElectrinico());
		
		repoAutor.save(autor);
		
	}

	@Override
	public void modificar(AutorDto clase) {
		
		if(clase.getIdentificacion()==null) {
			throw new ArgumentRequiredException("La identifacion del Autor es requerida");
		}
		Autor autor = repoAutor.findById(clase.getIdentificacion()).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));
		
		autor.setNombreCompleto(clase.getNombreCompleto());
		autor.setFechaNacimiento(clase.getFechaNacimiento());
		autor.setCiudadProcedencia(clase.getCiudadProcedencia());
		autor.setCorreoElectrinico(clase.getCorreoElectrinico());
		
		repoAutor.save(autor);
		
	}

	@Override
	public AutorDto buscaPorId(String id) {
		Autor autor = repoAutor.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Paciente no encontrado"));
		
		AutorDto dto=new AutorDto();
		dto.setIdentificacion(autor.getIdentificacion());
		dto.setNombreCompleto(autor.getNombreCompleto());
		dto.setFechaNacimiento(autor.getFechaNacimiento());
		dto.setCiudadProcedencia(autor.getCiudadProcedencia());
		dto.setCorreoElectrinico(autor.getCorreoElectrinico());
		
		return dto;
	}

	@Override
	public void eliminar(String id) {
		Autor autor = repoAutor.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));
		if(autor.getLibro() != null && autor.getLibro().size() > 0) {
			throw new BusinessLogicException("El Autor tiene libros registrados (Porfavor eliminar los libros) " );
		}else {
			
			repoAutor.deleteById(id);
		}
	}

	@Override
	public List<AutorDto> listarAutores() {
		// TODO Auto-generated method stub
		
		List<Autor> setear=repoAutor.findAll();
		List<AutorDto> dtoList= new ArrayList<AutorDto>();
		
		for (Autor autor : setear) {
			
			AutorDto dto=new AutorDto();
			dto.setIdentificacion(autor.getIdentificacion());
			dto.setNombreCompleto(autor.getNombreCompleto());
			dto.setFechaNacimiento(autor.getFechaNacimiento());
			dto.setCiudadProcedencia(autor.getCiudadProcedencia());
			dto.setCorreoElectrinico(autor.getCorreoElectrinico());
			
			dtoList.add(dto);
			
		}
		
		return dtoList;
	}

}
