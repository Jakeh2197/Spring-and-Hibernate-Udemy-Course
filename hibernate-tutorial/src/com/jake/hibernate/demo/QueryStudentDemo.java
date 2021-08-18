package com.jake.hibernate.demo;

import com.jake.hibernate.demo.entity.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> students = session.createQuery("from student").getResultList();
			
			// display the students
			for(Student s : students) {
				System.out.println(s.toString());
			}

			// commit transaction
			session.getTransaction().commit();

		}
		finally {
			factory.close();
		}
	}
}
