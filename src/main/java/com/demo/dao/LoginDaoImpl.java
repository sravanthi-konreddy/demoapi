package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory session;

	@Override
	public boolean isValidUser(User user) {
		
		Query query=session.getCurrentSession().createQuery("select count(*) from User where username=:uname and password=:pwd");
		query.setParameter("uname", user.getUsername());
		query.setParameter("pwd", user.getPassword());
		//int result=
		List result=query.getResultList();
		
		System.out.println(result);
		System.out.println("hello");
		System.out.println(result.get(0).toString());
		if((result.get(0)).toString().equals("1"))
			return true;
		return false;
		
	}

}
