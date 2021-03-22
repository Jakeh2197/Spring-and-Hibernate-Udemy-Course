package com.jake.hibernate.demo;

import com.jake.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Deleting student with ID of : " + studentId);
			
			Student student = session.get(Student.class, studentId);
			
			session.delete(student);
			session.getTransaction().commit();
			
			System.out.println("Finished!");
		}
		finally {
			factory.close();
		}
	}
}
