package com.cts.employeemanagemnt.bean;

public class Employee {
	private String employeeId;
	private String firstName;
	private String lastName;
	private int salary;
	
	private static Employee employee;
	public static Employee getInstance(){
		if(employee == null){
			employee = new Employee();
			return employee;
		}
		else
			return employee;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(String employeeId, String firstName, String lastName, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
}
