package com.jake.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Course;
import com.jake.hibernate.demo.entity.Instructor;
import com.jake.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// retrieve the instructor
			int id = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i " 
															+ "JOIN FETCH i.courses "
															+ "where i.id=:theInstructorId", 
															Instructor.class);
													
			// set the parameter
			query.setParameter("theInstructorId", id);
			
			// execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("The instructor: " + instructor.toString());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Instructor has been saved!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
