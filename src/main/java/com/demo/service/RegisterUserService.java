package com.demo.service;

import com.demo.model.User;

public interface RegisterUserService {
	
	public int registerUser(User user);
	
	public boolean checkIfUsernameAlreadyExists(User user);

}
