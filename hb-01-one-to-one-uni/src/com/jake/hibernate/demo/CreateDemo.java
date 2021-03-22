package com.jake.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Instructor;
import com.jake.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor instructor = new Instructor("Chelsea", "Henderson", "jake@jake.com");
			
			InstructorDetail detail = new InstructorDetail("youtubechannel.com", "Spending too much time on her phone");
			
			// associate the objects
			instructor.setInstructorDetail(detail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// cascade will mean instructor detail object will be saved as well
			System.out.println("Saving instructor: " + instructor.toString());
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Instructor has been saved!");
		}
		finally {
			factory.close();
		}
	}
}
