package com.jake.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
