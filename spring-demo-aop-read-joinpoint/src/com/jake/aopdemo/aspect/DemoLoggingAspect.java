package com.jake.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jake.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
	// add code for related advices
	
	@Before("com.jake.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("=====>>>>> Executing @before advice on method");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		// display the method arguments
		// get args
		Object[] args = joinPoint.getArgs();
		
		// loop through args
		for(Object o : args) {
			System.out.println(o);
			
			if(o instanceof Account) {
				// downcast and print account information
				Account account = (Account) o;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}

}
