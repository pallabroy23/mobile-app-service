package com.appsdevelopment.app.ws.mobileappservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appsdevelopment.app.ws.mobileappservice.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		String message = ex.getLocalizedMessage();
		if(ex.getLocalizedMessage()==null)
			message = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),message);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class,UserServiceException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest request) {
		String message = ex.getLocalizedMessage();
		if(ex.getLocalizedMessage()==null)
			message = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),message);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
