package com.credibanco.assessment.library.service.impl;

import java.util.List;

import com.credibanco.assessment.library.dto.LibroDto;

public interface LibroServiceImpl {
	
	public void guardar(LibroDto clase);
	public void eliminar(String id);
	public List<LibroDto>ListarLibrosCorrecto();
	public List<LibroDto>ListarCleintApi(String es);

}
