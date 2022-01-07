package com.credibanco.assessment.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dto.LibroDto;
import com.credibanco.assessment.library.exceptions.BusinessLogicException;
import com.credibanco.assessment.library.exceptions.ModelNotFoundException;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.repository.IAutorRepository;
import com.credibanco.assessment.library.repository.IEditorialRepository;
import com.credibanco.assessment.library.repository.ILibroRepository;
import com.credibanco.assessment.library.service.impl.LibroServiceImpl;

@Service
public class LibroServices implements LibroServiceImpl{
	
	@Autowired
	private ILibroRepository repoLibro;
	
	@Autowired
	private IEditorialRepository repoEditorialL;
	
	@Autowired
	private IAutorRepository repoAutorL;

	@Override
	public void guardar(LibroDto clase) {
		
		boolean exit= repoLibro.existsById(clase.getIsbn());
		
		if(exit==true) {
			
			throw new BusinessLogicException("El ISBN del libro ya esxite dentro del registro");
			
		}
		
		boolean encontrarAutor=repoAutorL.existsById(clase.getAutor());

		
		if(clase.getEditorial()!=null) {
			
			boolean enocntrarEditorial=repoEditorialL.existsById(clase.getEditorial());
			
			
			if(enocntrarEditorial==true && encontrarAutor==false) {
				
				throw new ModelNotFoundException("El autor no está registrado");
				
			}
			else if(enocntrarEditorial==false && encontrarAutor==true){
				
				throw new ModelNotFoundException("La editorial no está registrada");
				
			}
			else if(enocntrarEditorial==false && encontrarAutor==false){
				
				throw new ModelNotFoundException("La editorial y el autor no están registrados");
			}
			
			else {
				
				
				Integer cantidad=repoLibro.catidad(clase.getEditorial());
				Integer cantidadPrincipal=repoEditorialL.librosMaximos(clase.getEditorial());
				
				if(cantidadPrincipal.equals(cantidad)) {
					
					throw new BusinessLogicException("No es posible registrar el libro, se alcanzó el máximo permitido");
					
				}
				
				
				System.out.println(cantidad);
				System.out.println("Libro Maximos: "+cantidadPrincipal);
				
				Libro libro= new Libro();
				libro.setIsbn(clase.getIsbn());
				libro.setTitulo(clase.getTitulo());
				libro.setAño(clase.getFechadePublicacion());
				libro.setGenero(clase.getGenero());
				libro.setNumeroPaginas(clase.getNumeroPaginas());
				
				Editorial editorial =new Editorial();
				editorial.setIdentifcacionEditorial(clase.getEditorial());
				
				Autor autor = new Autor();
				autor.setIdentificacion(clase.getAutor());
				
				libro.setEditorial(editorial);
				libro.setAutor(autor);
				
				repoLibro.save(libro);
			}
			
		}else {
			
            if(encontrarAutor==false) {
				
				throw new ModelNotFoundException("El autor no está registrado");
				
			}
            else {
            	
            	Libro libro= new Libro();
        		libro.setIsbn(clase.getIsbn());
        		libro.setTitulo(clase.getTitulo());
        		libro.setAño(clase.getFechadePublicacion());
        		libro.setGenero(clase.getGenero());
        		libro.setNumeroPaginas(clase.getNumeroPaginas());
        		
        		Autor autor = new Autor();
        		autor.setIdentificacion(clase.getAutor());
        		
        		libro.setAutor(autor);
            	
            	repoLibro.save(libro);	
            }
			
		}
		
	}

	@Override
	public void eliminar(String id) {
		boolean exit= repoLibro.existsById(id);
		
		if(exit==false) {
			
			throw new ModelNotFoundException("El Libro no se encuentra dentro del registro");
			
		}
		
		repoLibro.deleteById(id);
		
	}


	@Override
	public List<LibroDto> ListarLibrosCorrecto() {
		
		List<Libro> lsitar=repoLibro.findAll();
		if(lsitar.size()==0) {
			
			throw new ModelNotFoundException("No hay elementos en la lista");
			
		}
		
		List<LibroDto> nuevaLista=new ArrayList<LibroDto>();
		
		for (Libro libro : lsitar) {
			LibroDto liD=new LibroDto();
			
			liD.setIsbn(libro.getIsbn());
			liD.setTitulo(libro.getTitulo());
			liD.setFechadePublicacion(libro.getAño());
			liD.setGenero(libro.getGenero());
			liD.setNumeroPaginas(libro.getNumeroPaginas());
			liD.setAutor(libro.getAutor().getNombreCompleto());
			if(libro.getEditorial()==null) {
				
				nuevaLista.add(liD);
				
			}else {
				
				liD.setEditorial(libro.getEditorial().getNombre());
				nuevaLista.add(liD);
				
			}
			
		}
		
		
		
		List<Libro> re=repoLibro.buscar("Terror");
		
		for (Libro libro : re) {
			
			System.out.println(libro.toString());
			
		}
		
		
		return nuevaLista;
		
	}

	@Override
	public List<LibroDto> ListarCleintApi(String es) {
		
		List<Libro> listaOb=repoLibro.filtroFinal(es);
		
		
		List<LibroDto> nuevaLista=new ArrayList<LibroDto>();
		
		    for (Libro libro : listaOb) {
		    	LibroDto liD=new LibroDto();
			
			    liD.setIsbn(libro.getIsbn());
			    liD.setTitulo(libro.getTitulo());
			    liD.setFechadePublicacion(libro.getAño());
			    liD.setGenero(libro.getGenero());
			    liD.setNumeroPaginas(libro.getNumeroPaginas());
			    liD.setAutor(libro.getAutor().getNombreCompleto());
			    if(libro.getEditorial()==null) {
					
					nuevaLista.add(liD);
					
				}else {
					
					liD.setEditorial(libro.getEditorial().getNombre());
					nuevaLista.add(liD);
					
				}
		}
		
		
		
		
		

		return nuevaLista;
	}

}
