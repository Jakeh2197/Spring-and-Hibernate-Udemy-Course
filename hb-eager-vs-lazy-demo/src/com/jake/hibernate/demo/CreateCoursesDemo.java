package com.jake.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Course;
import com.jake.hibernate.demo.entity.Instructor;
import com.jake.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// get the instructor from the db
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			// create some courses
			Course courseOne = new Course("Java");
			Course courseTwo = new Course("IRMS");
			
			// add courses to instructor
			instructor.addCourse(courseOne);
			instructor.addCourse(courseTwo);
			
			// save the courses
			session.save(courseOne);
			session.save(courseTwo);
			
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
