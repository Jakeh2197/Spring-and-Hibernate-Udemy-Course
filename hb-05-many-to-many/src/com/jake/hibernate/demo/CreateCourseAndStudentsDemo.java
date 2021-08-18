package com.jake.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jake.hibernate.demo.entity.Course;
import com.jake.hibernate.demo.entity.Instructor;
import com.jake.hibernate.demo.entity.InstructorDetail;
import com.jake.hibernate.demo.entity.Review;
import com.jake.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course course = new Course("Java: How to Land a Job!");
			
			System.out.println("Saving course");
			session.save(course);
			System.out.println("Course saved: " + course.toString());
			
			Student studentOne = new Student("Jake", "Henderson", "jake@jake.com");
			Student studentTwo = new Student("Chelsea", "Henderson", "jake@jake.com");
			
			course.addStudent(studentOne);
			course.addStudent(studentTwo);
			
			System.out.println("Saving students");
			session.save(studentOne);
			session.save(studentTwo);
			System.out.println("Students have been saved!");
			
			// save the course and leverage cascade all to save reviews
			session.save(course);
			
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
