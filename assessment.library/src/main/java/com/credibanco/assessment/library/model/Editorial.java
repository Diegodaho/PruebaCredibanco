package com.credibanco.assessment.library.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "editorial")
public class Editorial {
	
	@NotNull
	@Id
	@Column(name = "identificacion_editorial", nullable = false, length = 10)
	private String identifcacionEditorial;
	
	
	@NotNull
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@NotNull
	@Column(name = "direccion", nullable = false, length = 50)
	private String direccionCorespondencia;
	
	@NotNull
	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;
	
	//@NotNull
	@Column(name = "correo_electronico",length = 50)
	private String correoElectronico;
	
	@NotNull
	@Column(name = "maximo_libros")
	private Integer maximoLibrosRegistrados;
	
	@OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Libro> libro;

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

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}
	
	
	

}
