package com.credibanco.assessment.library.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AutorDto {
	
	@NotNull
	@Size(min = 10, max = 10, message = ":El numero de caracteres a registrar tiene que ser 10, ")
	private String identificacion;
	
	@NotNull(message = ":Porfavor ingrese el nombre del autor, ")
	private String nombreCompleto;
	
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Calendar fechaNacimiento;
	
	
	private String ciudadProcedencia;
	
	@Email
	private String correoElectrinico;

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudadProcedencia() {
		return ciudadProcedencia;
	}

	public void setCiudadProcedencia(String ciudadProcedencia) {
		this.ciudadProcedencia = ciudadProcedencia;
	}

	public String getCorreoElectrinico() {
		return correoElectrinico;
	}

	public void setCorreoElectrinico(String correoElectrinico) {
		this.correoElectrinico = correoElectrinico;
	}
	
	


}
