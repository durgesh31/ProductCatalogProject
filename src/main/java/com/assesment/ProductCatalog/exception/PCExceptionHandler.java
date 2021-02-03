package com.assesment.ProductCatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.assesment.ProductCatalog.bo.GenericAPIResponse;

@ControllerAdvice
public class PCExceptionHandler {

	public ResponseEntity<GenericAPIResponse> exceptionHandler(Exception ex){
		
		GenericAPIResponse response = new GenericAPIResponse("failure",ex.getMessage());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
		
	}
}
