package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.RegisterResponse;
import com.demo.model.User;
import com.demo.service.RegisterUserService;

@RestController
public class RegisterUserController {
	
	@Autowired 
	RegisterUserService registerUserService;
	
	@RequestMapping(value="/api/registerUser",method=RequestMethod.POST)
	public ResponseEntity<RegisterResponse> registerUser(@RequestBody User user)
	{
		RegisterResponse response;
		if (registerUserService.checkIfUsernameAlreadyExists(user)) {
			if (registerUserService.registerUser(user) > 0) {
				response = new RegisterResponse();
				response.setResponseCode(1);
				response.setResponseMessage("Insert Success");
				response.setResponseStatus("OK");
				return ResponseEntity.ok().body(response);
			} else {
				response = new RegisterResponse();
				response.setResponseCode(0);
				response.setResponseMessage("Error while inserting");
				response.setResponseStatus("OK");
				return ResponseEntity.ok().body(response);
			}
		} else {
			response = new RegisterResponse();
			response.setResponseCode(0);
			response.setResponseMessage("UserName already exists..");
			response.setResponseStatus("OK");
			return ResponseEntity.ok().body(response);
		}
	}

}
