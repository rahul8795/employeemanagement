package com.cts.employeemanagemnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagemnt.util.DBUtils;

public class LoginDAOImpl implements LoginDAO {
	
	private static LoginDAOImpl loginDAOImpl;
	public static LoginDAOImpl getInstance(){
		if(loginDAOImpl == null){
			loginDAOImpl = new LoginDAOImpl();
			return loginDAOImpl;
		}
		else
			return loginDAOImpl;
	}
	private LoginDAOImpl(){
		
	}

	public String getUserStatus(String id) {
		// TODO Auto-generated method stub
		String query = "select status from login where userid=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "admin";
	}

	public String getUserType(String id) {
		// TODO Auto-generated method stub
		String query = "select usertype from login where userid=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("usertype");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return "admin";
	}

	@Override
	public boolean authenticate(String id, String password) {
		// TODO Auto-generated method stub\
		String query = "select * from login where userid=? and password=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet  resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
