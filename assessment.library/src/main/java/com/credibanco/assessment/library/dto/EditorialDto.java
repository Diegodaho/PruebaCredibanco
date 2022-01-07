package com.credibanco.assessment.library.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditorialDto {
	
	@NotNull(message = ":Porfavor ingrese la identificacion de la editorial, ")
	@Size(min = 10, max = 10, message = ":El numero de caracteres a registrar tiene que ser 10, ")
	private String identifcacionEditorial;
	
	@NotNull(message = ":Porfavor ingrese el nombre de la editorial, ")
	private String nombre;
	
	@NotNull(message = ":Porfavor ingrese la correspondencia de la editorial, ")
	private String direccionCorespondencia;
	
	@NotNull(message = ":Porfavor ingrese el telefono de la editorial, ")
	private String telefono;
	
	@Email
	private String correoElectronico;
	
	@NotNull(message = ":Porfavor ingrese el maximo de libros a registrar, ")
	private Integer maximoLibrosRegistrados;

	public String getIdentifcacionEditorial() {
		return identifcacionEditorial;
	}

	public void setIdentifcacionEditorial(String identifcacionEditorial) {
		this.identifcacionEditorial = identifcacionEditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccionCorespondencia() {
		return direccionCorespondencia;
	}

	public void setDireccionCorespondencia(String direccionCorespondencia) {
		this.direccionCorespondencia = direccionCorespondencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Integer getMaximoLibrosRegistrados() {
		return maximoLibrosRegistrados;
	}

	public void setMaximoLibrosRegistrados(Integer maximoLibrosRegistrados) {
		this.maximoLibrosRegistrados = maximoLibrosRegistrados;
	}
	
	

}
