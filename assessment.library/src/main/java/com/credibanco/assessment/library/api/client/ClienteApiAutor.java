package com.credibanco.assessment.library.api.client;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.credibanco.assessment.library.dto.AutorDto;


public class ClienteApiAutor {
	
	private static final String LISTAR_TODOS_LOS_AUTORES="http://localhost:8080/autores/listar";
	private static final String GUARDAR_AUTOR="http://localhost:8080/autores/guardar";
	static RestTemplate resTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		
		listarTodosAutores();
		guardarAutores();
		
	}
	
	private static void listarTodosAutores() {
		
		HttpHeaders head = new HttpHeaders();
		head.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity =new HttpEntity<>("parametros", head);
		
		ResponseEntity<String> listaResult=resTemplate.exchange(LISTAR_TODOS_LOS_AUTORES, HttpMethod.GET, entity, String.class);
		System.out.println(listaResult);
	}
	
	public static void guardarAutores() {
		
		Calendar cal= new GregorianCalendar(2016,7,5);
		
		AutorDto dto = new AutorDto();
		dto.setIdentificacion("1234567891");
		dto.setNombreCompleto("Fabio Garcia");
		dto.setFechaNacimiento(cal);
		dto.setCiudadProcedencia("Facatativa");
		dto.setCorreoElectrinico("fabio@hotmail.com");
		
		ResponseEntity<AutorDto> listaResult=(ResponseEntity<AutorDto>) resTemplate.postForEntity(GUARDAR_AUTOR, dto, AutorDto.class);
		System.out.println(listaResult.getBody());
		
	}
	
	

}
