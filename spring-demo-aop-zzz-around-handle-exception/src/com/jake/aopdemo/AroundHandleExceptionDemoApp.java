package com.jake.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jake.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true;
		System.out.println("\n" + service.getFortune(tripWire));
		
		System.out.println("Finished");
		
		// close the context
		context.close();
	}

}