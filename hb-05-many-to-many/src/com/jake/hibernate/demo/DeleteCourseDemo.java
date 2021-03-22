package com.jake.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Course;
import com.jake.hibernate.demo.entity.Instructor;
import com.jake.hibernate.demo.entity.InstructorDetail;
import com.jake.hibernate.demo.entity.Review;
import com.jake.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Review.class)
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course to be deleted
			int id = 1;
			Course course = session.get(Course.class, id);
			
			// delete the course
			System.out.println("Deleting course: " + course);
			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
