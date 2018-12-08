package com.mycode;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class ControllerCommonExceptionController extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionCommonResponse ecr = new ExceptionCommonResponse(new Date(), ex.getMessage());
		ResponseEntity re = new ResponseEntity(ecr, HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
	
	@ExceptionHandler(ExceptionInvalidTypeException.class)
	ResponseEntity<Object> handleInvalidTypeExceptions(Exception ex, WebRequest request){
		ExceptionCommonResponse ecr = new ExceptionCommonResponse(new Date(), ex.getMessage());
		ResponseEntity re = new ResponseEntity(ecr, HttpStatus.NOT_ACCEPTABLE);
		return re;
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionCommonResponse ecr = new ExceptionCommonResponse(new Date(), ex.getBindingResult().toString());
		ResponseEntity re = new ResponseEntity(ecr, HttpStatus.BAD_REQUEST);
		return re;
	}

}
