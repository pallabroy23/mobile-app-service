package com.appsdevelopment.app.ws.mobileappservice.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdevelopment.app.ws.mobileappservice.exceptions.UserServiceException;
import com.appsdevelopment.app.ws.mobileappservice.model.request.User;
import com.appsdevelopment.app.ws.mobileappservice.model.response.UserDetails;


@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value = "page",defaultValue = "1")int page, 
			@RequestParam(value = "limit", defaultValue = "5") int limit,
			@RequestParam(value = "sort", defaultValue = "desc") String sort) {
		/*
		 * if(limit!=null) { return
		 * "users are retrieved from page no. = "+page+" and have limit of = "+limit; }
		 * else {
		 */
			return "users are retrieved from page no. = "+page+" and have limit of = "+limit+" with sort order = "+sort;
		
	}

	@GetMapping(path="/{userId}", 
			produces = {MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		
		if(true)throw new UserServiceException("User service exception is thrown");
		
		User user = new User();
		user.setFirstName("Monami");
		user.setLastName("Roy");
		user.setEmail("monamiroy02@gmail.com");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetails userDetails) {
		User returnValue = new User();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		
		return new ResponseEntity<User>(returnValue, HttpStatus.OK);
	}

	@PutMapping
	public String updateUser() {
		return "user is updated";
	}

	@DeleteMapping
	public String deleteUser() {
		return "user is deleted";
	}
}
