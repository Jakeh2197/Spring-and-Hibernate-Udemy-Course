package com.jake;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.entities.Employee;


public class UpdateEmployee {

	public void updateEmployee(int id, String firstName, String lastName, String company) {
		
		try(SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class)
				 .buildSessionFactory()) {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, id);
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setCompany(company);
			
			session.getTransaction().commit();
		}
	}
}
