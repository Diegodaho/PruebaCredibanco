package com.credibanco.assessment.library.service.impl;

import java.util.List;

import com.credibanco.assessment.library.dto.EditorialDto;



public interface EditorialServiceImpl {
	
	public void guardar(EditorialDto clase);
	public void modificar(EditorialDto clase);
	public EditorialDto buscaPorId(String id);
	public void eliminar(String id);
	public List<EditorialDto> listareditoriales();


}
