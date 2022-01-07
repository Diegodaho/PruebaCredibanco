package com.credibanco.assessment.library.exceptions;

public class BusinessLogicException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public BusinessLogicException(String mensaje) {		
		super(mensaje);
	}

}
