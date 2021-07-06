package com.jake.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jake.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// an empty class is all you need, required methods are provided by JpaRepository
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

}
