package com.jake.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Instructor;
import com.jake.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// get instructor detail object
			int id = 4;
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			// print instructor detail
			System.out.println("Instructor detail: " + detail.toString());
			
			// print associated instructor
			System.out.println("Assocaited instructor: " + detail.getInstructor().toString());
			
			System.out.println("Deleting instructor detail: " + detail);
			
			// remove assocaited object reference
			detail.getInstructor().setInstructorDetail(null);
			
			// delete the instructorDetail
			session.delete(detail);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Instructor has been saved!");
		}
		catch(NullPointerException e) {
//			e.printStackTrace();
			System.out.println("Instructor detail not found");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
