package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.AuthorisedCustomer;

@Repository 
public class LoginDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public boolean loginValidation(String email, String password) {
		String query = "select ac from AuthorisedCustomer ac where ac.email =: em and ac.password =: pwd";
		Query q=entityManager.createQuery(query);
		q.setParameter("em", email);
		q.setParameter("pwd", password);
		try 
		{
			AuthorisedCustomer ac = (AuthorisedCustomer) q.getSingleResult();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

}
