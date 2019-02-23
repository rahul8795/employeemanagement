package com.cts.employeemanagemnt.service;

import java.util.List;

import com.cts.employeemanagemnt.bean.Employee;
import com.cts.employeemanagemnt.dao.EmployeeDAO;
import com.cts.employeemanagemnt.dao.EmployeeDAOImpl;



public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	@Override
	public String addEmplyee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmplyee(employee);
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(id, employee);
	}

	@Override
	public String deleteEmploee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmploee(id);
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee();
	}
}
