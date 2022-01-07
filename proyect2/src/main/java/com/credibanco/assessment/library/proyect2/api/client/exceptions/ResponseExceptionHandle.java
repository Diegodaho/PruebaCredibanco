package com.credibanco.assessment.library.proyect2.api.client.exceptions;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.credibanco.assessment.library.proyect2.dto.ErrorDto;








@Controller
@ControllerAdvice
public class ResponseExceptionHandle extends ResponseEntityExceptionHandler {
	
	
	
  
	@ExceptionHandler(NoHandlerFoundException.class)
	public final ResponseEntity<ErrorDto> NoHandlerFoundException (NoHandlerFoundException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.NOT_FOUND);			
	}
	
	@ExceptionHandler(ArgumentRequiredException.class)
	public final ResponseEntity<ErrorDto> ArgumentRequiredExceptionHandler (ArgumentRequiredException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
	}
	
	@ExceptionHandler(BusinessLogicException.class)
	public final ResponseEntity<ErrorDto> BusinessLogicExceptionHandler (BusinessLogicException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
	}
	
	
	/*@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<ErrorDto> ModelNotFoundExceptionHandler (ModelNotFoundException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.toString().intern(),ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.NOT_FOUND);			
	}*/
	
	@ExceptionHandler(ModelNotFoundException.class)
	public final String ModelNotFoundExceptionHandlerView (ModelNotFoundException ex,
			WebRequest request, Model model){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.toString().intern(),ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		model.addAttribute("objeto",error);
		return "error";			
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDto>ExceptionHandler (Exception ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.name(),  HttpStatus.INTERNAL_SERVER_ERROR.toString().intern(),  ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	
	
	
	/*@ExceptionHandler(NotFoundModelException.class)
	public final ResponseEntity<ErrorDto> ModelNotFoundExceptionHandler (NotFoundModelException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.toString().intern(), ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.NOT_FOUND);			
	}*/
	
	@ExceptionHandler(NotFoundModelException.class)
	public final String ModelNotFoundExceptionHandlerView (NotFoundModelException ex,
			WebRequest request,Model model){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.toString().intern(), ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		model.addAttribute("objeto",error);
		return "error";			
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorDto> ModelNullPointerException (NullPointerException ex,
			WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.toString().intern(), ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        
        
        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getField() + " " + f.getDefaultMessage() +  " "));
		
		ex.printStackTrace();
		ErrorDto error = new ErrorDto( HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.toString().intern() ,errorMessage.toString(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		
		
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(status.name(), status.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(status.name(), status.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}
	

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(status.name(),status.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);	
		
		
		
	}


	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(status.name(),status.toString().intern(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
	public final ResponseEntity<ErrorDto> MethodArgumentTypeMismatchException (org.springframework.web.method.annotation.MethodArgumentTypeMismatchException ex,
			HttpStatus status,WebRequest request){
		ex.printStackTrace();
		ErrorDto error = new ErrorDto(status.name(), status.toString(),ex.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
	}
	
	
	
	
	



	
	
	

}
