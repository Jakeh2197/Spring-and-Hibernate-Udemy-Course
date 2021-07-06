package com.jake.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jake.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// setup constructor injection
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// create query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		//return the result list
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee = session.get(Employee.class, id);
		
		//return the employee
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// save employee
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// delete the employee
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}

}
