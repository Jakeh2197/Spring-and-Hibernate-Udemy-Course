package com.jake.springboot.cruddemo.service;

import java.util.List;

import com.jake.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteById(int id);

}
