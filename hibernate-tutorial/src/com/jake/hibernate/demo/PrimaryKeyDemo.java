package com.jake.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a 3 student objects
			System.out.println("Creating a new students...");
			Student student1 = new Student("Jake", "Henderson", "jake@jake.com");
			Student student2 = new Student("Chelsea", "Henderson", "chelsea@jake.com");
			Student student3 = new Student("Lilith", "Henderson", "lilith@jake.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student
			System.out.println("Saving the students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Student has been saved!");
		}
		finally {
			factory.close();
		}
	}

}
