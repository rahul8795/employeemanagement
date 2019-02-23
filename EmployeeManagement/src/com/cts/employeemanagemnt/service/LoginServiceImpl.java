package com.cts.employeemanagemnt.service;

import com.cts.employeemanagemnt.dao.LoginDAO;
import com.cts.employeemanagemnt.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	private static LoginServiceImpl loginServiceImpl;
	private LoginDAO dao = LoginDAOImpl.getInstance();
	
	public static LoginServiceImpl getInstance(){
		if(loginServiceImpl == null){
			loginServiceImpl = new LoginServiceImpl();
			return loginServiceImpl;
		}
		else
			return loginServiceImpl;
	}
	private  LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getUserStatus(String id) {
		// TODO Auto-generated method stub
		return dao.getUserStatus(id);
	}

	@Override
	public String getUserType(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}

	@Override
	public boolean authenticate(String id, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(id, password);
	}
	@Override
	public String authorization(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}

}
