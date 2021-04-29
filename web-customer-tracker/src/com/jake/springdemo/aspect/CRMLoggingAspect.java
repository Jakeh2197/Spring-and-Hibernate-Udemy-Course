package com.jake.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.jake.springdemo.controller.*.*(..))")
	private void forControllerPackage() {};
	
	@Pointcut("execution(* com.jake.springdemo.service.*.*(..))")
	private void forServicePackage() {};
	
	@Pointcut("execution(* com.jake.springdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {
		// display method we are calling
		String methodSig = joinPoint.getSignature().toShortString();
		
		logger.info("\n\n=====>>> in @Before: calling method: " + methodSig + "\n");
		
		// display the arguments to the method
		Object[] args = joinPoint.getArgs();
		
		for(Object o : args) {
			logger.info("\n\n=====>>> argument: " + o + "\n");
		}
		
	}
	
	// add @AfterReturning
	@AfterReturning(pointcut="forAppFlow()",
			        returning="result")
	private void afterReturning(JoinPoint joinPoint, Object result) {
		// display the method we are returning from
		String methodSig = joinPoint.getSignature().toShortString();
		
		logger.info("\n\n=====>>> in @AFterReturning: from method: " + methodSig + "\n");
		
		// display the data returned
		
		logger.info("\n\n=====>>> result: " + result + "\n");
	}
	
}
