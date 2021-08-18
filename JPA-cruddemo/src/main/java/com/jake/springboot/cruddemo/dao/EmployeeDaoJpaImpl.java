package com.jake.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jake.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		// create a query
		Query query = entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		// get employee
		Employee employee = entityManager.find(Employee.class, id);
		
		// return employee
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		// save or update employee
		Employee emp = entityManager.merge(employee);
		
		// update with id from db so we can get generated id for save/insert
		
		employee.setId(emp.getId());
		
	}

	@Override
	public void deleteById(int empId) {
		
		// delete object by primary key
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", empId);
		
		query.executeUpdate();
	}

}
