package com.credibanco.assessment.library.proyect2.dto;

import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LibroDto {
	
    private String isbn;
	
	private String titulo;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Calendar fechadePublicacion;

	private String genero;
	
	private Integer numeroPaginas;
	
	private String editorial;
	
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
