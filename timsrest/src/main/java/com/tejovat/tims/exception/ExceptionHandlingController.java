package com.tejovat.tims.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author YogeshL
 */
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(TIMSException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(TIMSException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode( HttpStatus.NOT_FOUND.value());
		response.setErrorMessage(ex.getErrorMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(1);
		response.setErrorMessage("Invalid inputs.");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

}