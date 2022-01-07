package com.credibanco.assessment.library.dto;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


public class LibroDto {
	
	@NotNull(message = ":Porfavor ingrese el ISBN del libro, ")
	@Size(min = 13, max = 13, message = ":El numero de caracteres a registrar es de 13, ")
	private String isbn;
	
	@NotNull(message = ":Porfavor ingrese el titulo del libro, ")
	private String titulo;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Calendar fechadePublicacion;

	@NotNull(message = ":Porfavor ingrese el genero del libro, ")
	private String genero;
	
	@NotNull(message = ":Porfavor ingrese el numero de paginas del libro, ")
	private Integer numeroPaginas;
	
	private String editorial;
	
	@NotNull(message = ":Porfavor ingrese el autor del libro, ")
	private String autor;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getFechadePublicacion() {
		return fechadePublicacion;
	}

	public void setFechadePublicacion(Calendar fechadePublicacion) {
		this.fechadePublicacion = fechadePublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	

	

	
}
