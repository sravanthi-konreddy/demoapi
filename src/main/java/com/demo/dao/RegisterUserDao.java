package com.demo.dao;

import com.demo.model.User;

public interface RegisterUserDao {
	
	public int registerUser(User user);
	
	public boolean checkIfUsernameAlreadyExists(User user);

}
