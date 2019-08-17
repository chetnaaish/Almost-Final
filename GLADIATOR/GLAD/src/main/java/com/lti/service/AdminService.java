package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.LoginDao;
import com.lti.dao.SearchDao;
import com.lti.entity.Admin;
import com.lti.entity.AuthorisedCustomer;

@Service
public class AdminService {
	
	@Autowired
	private SearchDao dao;
	
	@Autowired
	private LoginDao logindao;

	@Transactional
    public int add(Admin adm) {
	Admin updatedDetails = (Admin) dao.save(adm);
	return updatedDetails.getAdminid();
	}
	
	   public boolean get(Admin adm) {
			String email = adm.getAdminemail();
			String password = adm.getAdminpassword();
			return logindao.loginValidation(email, password);
		}
}
