package com.credibanco.assessment.library.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "autor")
public class Autor {
	
	@NotNull
	@Id
	@Size(min = 10, max = 10, message = ":El numero de caracteres a registrar tiene que ser 10, ")
	@Column(name = "identificacion", nullable = false, length = 10)
	private String identificacion;
	
	@NotNull
	@Column(name = "nombre_completo", nullable = false, length = 100)
	private String nombreCompleto;
	
	//@NotNull
	@Column(name = "fecha_nacimeinto")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Calendar fechaNacimiento;
	
	//@NotNull
	@Column(name = "ciudad_procedencia")
	private String ciudadProcedencia;
	
	//@NotNull
	@Email
	@Column(name = "correo_electronico")
	private String correoElectrinico;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Libro> libro;
	
	
	

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

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}
	
	
	
	
	
	
	
	

}
