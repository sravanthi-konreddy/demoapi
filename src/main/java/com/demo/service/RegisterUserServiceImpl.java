package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.RegisterUserDao;
import com.demo.model.User;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	RegisterUserDao registerUserDao;
	
	@Override
	@Transactional
	public int registerUser(User user) {
		return registerUserDao.registerUser(user);
	}

	@Override
	@Transactional
	public boolean checkIfUsernameAlreadyExists(User user) {
		return registerUserDao.checkIfUsernameAlreadyExists(user);
	}

}
