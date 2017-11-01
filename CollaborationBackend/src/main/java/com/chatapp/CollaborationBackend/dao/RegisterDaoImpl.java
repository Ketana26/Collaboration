package com.chatapp.CollaborationBackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatapp.CollaborationBackend.model.Registration;

@Repository("registerDao")
@Transactional
public class RegisterDaoImpl implements RegisterDaoInt {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean registerUser(Registration register) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.save(register);
		return true;
	}catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
	}

	}

}