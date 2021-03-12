package com.jake;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.entities.Employee;

public class DeleteEmployee {
	
	public void deleteEmployee(int id) {
		try(SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class)
				 .buildSessionFactory()) {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("DELETE FROM Employee WHERE id=" + id).executeUpdate();
			session.getTransaction().commit();
		}
	}

}
