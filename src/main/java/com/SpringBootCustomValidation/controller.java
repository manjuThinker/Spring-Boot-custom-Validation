package com.SpringBootCustomValidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCustomValidation.payload.SignupRequest;

import jakarta.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/auth")
public class controller {
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest request){
		
		System.out.print(request);
		
		/*
		 * if(result.hasErrors()) { System.out.print(result.getFieldError()); }
		 */
		return new ResponseEntity<>("user registered successfully", HttpStatus.OK);
	}

}
