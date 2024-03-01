package org.jsp.adminHospital.exception;

import org.jsp.adminHospital.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
	public class BranchExceptionHandler extends ResponseEntityExceptionHandler{
		@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlerINFE(IdNotFoundException e){
			ResponseStructure< String> structure=new ResponseStructure<>();
			structure.setData(e.getMessage());
			structure.setMesssage("user not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		} 
		@ExceptionHandler(InvalidCredentialsException.class)
		public ResponseEntity<ResponseStructure<String>> handlerINCE(InvalidCredentialsException e){
				ResponseStructure< String> structure=new ResponseStructure<>();
				structure.setData(e.getMessage());
				structure.setMesssage("user not found");
				structure.setStatusCode(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
			} 
	}

