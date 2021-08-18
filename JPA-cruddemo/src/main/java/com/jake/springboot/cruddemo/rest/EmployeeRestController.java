package com.jake.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jake.springboot.cruddemo.entity.Employee;
import com.jake.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.getEmployeeById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee ID not found - " + employeeId);
		}
		
		return employee;
	}
	
	// add mapping for POST /employees to add new employees
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		// set ID to 0 to ensure its a new customer
		employee.setId(0);
		
		employeeService.saveEmployee(employee);
		
		return employee;
	}
	
	// add mapping for PUT /employees to update an existing customer
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		
		return employee;
	}
	
	// add DELETE mapping for /employees/{employeeId} to delete an existing employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee ID not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee ID - " + employeeId;
	}
}
