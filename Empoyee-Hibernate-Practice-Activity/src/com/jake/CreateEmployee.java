package com.jake;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.entities.Employee;

public class CreateEmployee {
	
	
	
	public void saveEmployee(String firstName, String lastName, String company) {
		Employee employee = new Employee(firstName, lastName, company);
		
		try(SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class)
				 .buildSessionFactory()) {
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.save(employee);
			
			session.getTransaction().commit();
		}
	}
	
}
