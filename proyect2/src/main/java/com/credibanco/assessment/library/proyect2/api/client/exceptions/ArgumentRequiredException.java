package com.credibanco.assessment.library.proyect2.api.client.exceptions;

public class ArgumentRequiredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ArgumentRequiredException(String mensaje) {		
		super(mensaje);
	}

}
