package com.jake.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.jake.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
		// print out method 
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = null;
		
		
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			result = "The exception was caught. Traffic will suck.";
			
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// calculate duration
		long duration = end - begin;
		System.out.println("\n======>>> Duration: " + duration / 1000.000 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.jake.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		// print out method 
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(pointcut="execution(* com.jake.aopdemo.dao.AccountDAO.findAccounts(..))",
			       throwing="exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		// print out method 
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n======>>> Exception is: " + exception);
	}
	
	// add advice for @AfterReturning on findAccounts method
	@AfterReturning(pointcut="execution(* com.jake.aopdemo.dao.AccountDAO.findAccounts(..))",
			        returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n======>>> Result is: " + result);
		
		// post-process the data
		convertAccountNamesToUpperCase(result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
			for(Account acc : result) {
				String name = acc.getName().toUpperCase();
				
				acc.setName(name);
			}
	}

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
