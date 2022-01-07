package com.credibanco.assessment.library.proyect2.api.client.exceptions;

public class BusinessLogicException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public BusinessLogicException(String mensaje) {		
		super(mensaje);
	}

}
