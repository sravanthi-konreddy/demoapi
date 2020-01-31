package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDao;
import com.demo.model.User;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	@Override
	@Transactional
	public boolean isValidUser(User user) {
		// TODO Auto-generated method stub
		return loginDao.isValidUser(user);
	}

}
