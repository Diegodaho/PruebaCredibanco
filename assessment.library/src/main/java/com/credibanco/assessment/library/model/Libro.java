package com.credibanco.assessment.library.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "libro")
public class Libro {
	
	
	@NotNull(message = ":Porfavor ingrese el ISBN del libro, ")
	@Size(min = 13, max = 13, message = ":El numero de caracteres a registrar es de 13, ")
	@Id
	@Column(name = "isbn", nullable = false, length = 13)
	private String isbn;
	
	@NotNull(message = ":Porfavor ingrese el titulo del libro, ")
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	
	//@NotNull(message = ":Porfavor ingrese el año en que se publico, incluir mes y dia, ")
	@Column(name = "año")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Calendar año;
	
	@NotNull(message = ":Porfavor ingrese el genero del libro, ")
	@Column(name = "genero", nullable = false, length = 50)
	private String genero;
	
	@NotNull(message = ":Porfavor ingrese el ISBN del libro, ")
	@Column(name = "numero_paginas", nullable = false)
	private Integer numeroPaginas;
	
	
	//@NotNull(message = ":Porfavor ingrese la editorial, ")
	@ManyToOne
	@JoinColumn(name = "id_editorial", foreignKey = @ForeignKey(name = "FK_Editorial_Libro"))
	private Editorial editorial;
	

	@NotNull(message = ":Porfavor ingrese el autor del libro, ")
	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false, foreignKey = @ForeignKey(name = "FK_Autor_Libro"))
	private Autor autor;

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

	public Calendar getAño() {
		return año;
	}

	public void setAño(Calendar año) {
		this.año = año;
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

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
	

}
