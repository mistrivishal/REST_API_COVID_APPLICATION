package com.covidapp.exceptionhandler;

import java.time.LocalDateTime;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandlerMain(Exception ex, WebRequest wr) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
									ex.getMessage(),
									wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RollbackException.class)
	public ResponseEntity<MyErrorDetails> handleRollbackException(Exception exp, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
									"Improper arguments passed in jason. Validation failed!",
									req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
									nfe.getMessage(),
									req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException manv,
			WebRequest wr) {
		String message = manv.getBindingResult().getFieldError().getDefaultMessage();
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), 
									message,
									wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MyErrorDetails> handleValidationException(Exception exp, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
									"Improper arguments passed in json. Validation failed",
									req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CenterException.class)
	public ResponseEntity<MyErrorDetails> centerException(CenterException cexp, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
									cexp.getMessage(),
									req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<MyErrorDetails> memberNotFoundException(MemberNotFoundException mexp, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
								mexp.getMessage(),
								req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
