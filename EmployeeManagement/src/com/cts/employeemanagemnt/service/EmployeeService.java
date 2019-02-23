package com.cts.employeemanagemnt.service;

import java.util.List;

import com.cts.employeemanagemnt.bean.Employee;


public interface EmployeeService {
	public String addEmplyee(Employee employee);
	public String updateEmployee(String id,Employee employee);
	public String deleteEmploee(String id);
	public Employee getEmployee(String id);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getEmployee();
}
