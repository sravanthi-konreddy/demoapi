package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/api/user",method=RequestMethod.POST)
	public ResponseEntity<Boolean> isValidUser(@RequestBody User user)
	{
		boolean result=loginService.isValidUser(user);
		return ResponseEntity.ok().body(result);
	}

}
