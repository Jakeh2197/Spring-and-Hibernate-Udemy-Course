package com.jake.hibernate.demo;

import com.jake.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating a new student...");
			Student student = new Student("Jake", "Henderson", "jake@jake.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student
			System.out.println("Saving the student...");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Student has been saved!");
		}
		finally {
			factory.close();
		}
	}
}
