package com.SpringBootCustomValidation.exception;

import java.util.ArrayList;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request){
		 ArrayList<String> errors = new ArrayList<>();

		    ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

		    Map<String, List<String>> result = new HashMap<>();
		    result.put("errors", errors);

		    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

}
