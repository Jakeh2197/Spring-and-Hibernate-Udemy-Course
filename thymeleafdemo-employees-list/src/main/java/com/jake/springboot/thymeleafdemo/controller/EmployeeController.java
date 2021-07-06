package com.jake.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jake.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		Employee employeeOne = new Employee(1, "Jake", "Henderson", "jake@jake.com");
		Employee employeeTwo = new Employee(2, "Chelsea", "Henderson", "chelsea@jake.com");
		Employee employeeThree = new Employee(3, "Lilith", "Henderson", "lilith@jake.com");
		
		employees = new ArrayList();
		
		employees.add(employeeOne);
		employees.add(employeeTwo);
		employees.add(employeeThree);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", employees);
		
		return "list-employees";
	}
}
