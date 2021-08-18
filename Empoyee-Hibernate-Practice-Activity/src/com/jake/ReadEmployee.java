package com.jake;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.entities.Employee;

public class ReadEmployee {
	
	private Employee employee;

	public String readStudent(String id) {
		try(SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class)
				 .buildSessionFactory()) {
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			employee = session.get(Employee.class, Integer.parseInt(id));
			
			String employeeInfo = employee.toString();
			
			return employeeInfo;
		}
	}
}
