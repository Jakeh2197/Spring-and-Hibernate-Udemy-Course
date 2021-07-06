package com.jake.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jake.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
