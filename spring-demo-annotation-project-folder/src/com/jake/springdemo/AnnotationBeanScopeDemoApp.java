package com.jake.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	
	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from the config file
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theOtherCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == theOtherCoach);
		
		// print out the results
		System.out.println("Pointing to the same objec: " + result);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for theOtherCoach: " + theOtherCoach);
		
		// close the context
		context.close();
	}

}
