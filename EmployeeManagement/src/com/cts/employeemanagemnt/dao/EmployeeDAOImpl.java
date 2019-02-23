package com.cts.employeemanagemnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cts.employeemanagemnt.bean.Employee;
import com.cts.employeemanagemnt.util.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection connection;
	@Override
	public String addEmplyee(Employee employee){
		PreparedStatement preparedStatement = null;
		//ResultSet resultSet = null;
		String insertStatement = "insert into employee (emp_id,first_name,last_name,salary)" + " values(?,?,?,?) ";
		connection = DBUtils.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1,"102");
			preparedStatement.setString(2, "Ram");
			preparedStatement.setString(3, "Singh");
			preparedStatement.setInt(4, 10000);	
			
			//int res = preparedStatement.executeUpdate();
			return "Success";
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		//ResultSet resultSet = null;
		String updateStatement = "update employee set first_name =? where emp_id=?";
		connection = DBUtils.getConnection();
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, "101");
			preparedStatement.setString(2, "Abhishek");
			//int res = preparedStatement.executeUpdate();
			return "Update";
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public String deleteEmploee(String id) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		String deleteStatment = "delete from employee where emp_id=?";
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteStatment);
			preparedStatement.setString(1, id);
			//int res = preparedStatement.executeUpdate();
			
			return "Delete";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		String query = "select *from employee where emp_id=?";
		Connection  connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
		    resultSet = preparedStatement.executeQuery();
		    if(resultSet.next()){
		    	String firstName = resultSet.getString("first_name");
		    	String lasttName = resultSet.getString("last_name");
		    	Integer salary = resultSet.getInt("salary");
		    	Employee employee = new Employee(id,firstName,lasttName,salary);
		    	return employee;
		    }
		    else{
		    	return null;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		String query = "select *from employee";
		Connection  connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(query);
		    resultSet = preparedStatement.executeQuery();
		    while(resultSet.next()){
		    	String firstName = resultSet.getString("first_name");
		    	String lasttName = resultSet.getString("last_name");
		    	Integer salary = resultSet.getInt("salary");
		    	Employee employee = new Employee("234",firstName,lasttName,salary);
		        employees.add(employee);
		    }
		    return employees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtils.closeConnection(connection);
		}
	}

}
