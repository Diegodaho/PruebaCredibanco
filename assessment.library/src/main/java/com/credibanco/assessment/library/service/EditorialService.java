package com.credibanco.assessment.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.exceptions.ArgumentRequiredException;
import com.credibanco.assessment.library.exceptions.BusinessLogicException;
import com.credibanco.assessment.library.exceptions.ModelNotFoundException;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.IEditorialRepository;
import com.credibanco.assessment.library.service.impl.EditorialServiceImpl;

@Service
public class EditorialService implements EditorialServiceImpl{
	
	@Autowired
	private IEditorialRepository repoEditorial;

	@Override
	public void guardar(EditorialDto clase) {
		
		boolean existenciaId =repoEditorial.existsById(clase.getIdentifcacionEditorial());
		boolean existenciaNom =repoEditorial.existsByNombre(clase.getNombre());
		if(existenciaId==false && existenciaNom==false) {
			
			
			Editorial editorial = new Editorial();
			
			editorial.setIdentifcacionEditorial(clase.getIdentifcacionEditorial());
			editorial.setNombre(clase.getNombre());
			editorial.setDireccionCorespondencia(clase.getDireccionCorespondencia());
			editorial.setTelefono(clase.getTelefono());
			editorial.setCorreoElectronico(clase.getCorreoElectronico());
			editorial.setMaximoLibrosRegistrados(clase.getMaximoLibrosRegistrados());
			
			
			if(clase.getMaximoLibrosRegistrados()==-1) {
					
				repoEditorial.save(editorial);
			}
			else if(clase.getMaximoLibrosRegistrados()>0) {
				
				repoEditorial.save(editorial);
			}
			else {
				throw new BusinessLogicException("La cantidad de libros tiene que ser -1 (no determinado) o mayor a cero");
			}
			
		}else {
			
			throw new BusinessLogicException("Porfaor verificar el Nombre y la Identificacion de la Editorial"
					+ "ya que La editorial se encuentra en la base de datos");
			
		}
		
		
	}

	@Override
	public void modificar(EditorialDto clase) {
		
		if(clase.getIdentifcacionEditorial()==null) {
			throw new ArgumentRequiredException("La identifacion de la editorial es requerida");
		}
		Editorial editorial = repoEditorial.findById(clase.getIdentifcacionEditorial()).orElseThrow(() 
				-> new ModelNotFoundException("Editorial no encontrada"));
		
		editorial.setNombre(clase.getNombre());
		editorial.setDireccionCorespondencia(clase.getDireccionCorespondencia());
		editorial.setTelefono(clase.getTelefono());
		editorial.setCorreoElectronico(clase.getCorreoElectronico());
		editorial.setMaximoLibrosRegistrados(clase.getMaximoLibrosRegistrados());
		
		
		
		
	}

	@Override
	public EditorialDto buscaPorId(String id) {
		Editorial editorial = repoEditorial.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Editorial no encontrada"));
		
		EditorialDto editorialDto = new EditorialDto();
		
		editorialDto.setIdentifcacionEditorial(editorial.getIdentifcacionEditorial());
		editorialDto.setNombre(editorial.getNombre());
		editorialDto.setDireccionCorespondencia(editorial.getDireccionCorespondencia());
		editorialDto.setTelefono(editorial.getTelefono());
		editorialDto.setCorreoElectronico(editorial.getCorreoElectronico());
		editorialDto.setMaximoLibrosRegistrados(editorial.getMaximoLibrosRegistrados());
		
		
		return editorialDto;
	}

	@Override
	public void eliminar(String id) {
		
		Editorial editorial = repoEditorial.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Editorial no encontrada"));
		if(editorial.getLibro() != null && editorial.getLibro().size() > 0) {
			throw new BusinessLogicException("La Editorial tiene libros registrados (Porfavor eliminar los libros) " );
		}else {
			
			repoEditorial.deleteById(id);
		}
		
	}

	@Override
	public List<EditorialDto> listareditoriales() {
		
		List<Editorial> setear=repoEditorial.findAll();
		List<EditorialDto> dtoList=new ArrayList<>();
		for(Editorial editorial: setear) {
			
			EditorialDto dto = new EditorialDto();
			
			dto.setIdentifcacionEditorial(editorial.getIdentifcacionEditorial());
			dto.setNombre(editorial.getNombre());
			dto.setDireccionCorespondencia(editorial.getDireccionCorespondencia());
			dto.setTelefono(editorial.getTelefono());
			dto.setCorreoElectronico(editorial.getCorreoElectronico());
			dto.setMaximoLibrosRegistrados(editorial.getMaximoLibrosRegistrados());
			
			dtoList.add(dto);
			
		}
		
		return dtoList;
	}

	

}
