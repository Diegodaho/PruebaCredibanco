package com.credibanco.assessment.library.service.impl;

import java.util.List;

import com.credibanco.assessment.library.dto.AutorDto;

public interface AutorServiceImpl {
	
	public void guardar(AutorDto clase);
	public void modificar(AutorDto clase);
	public AutorDto buscaPorId(String id);
	public void eliminar(String id);
	public List<AutorDto> listarAutores();

}
