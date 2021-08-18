package com.jake.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	// add code for related advices

	// @Pointcut is used to declare pointcut expressions
	// this makes refactoring simpler, code cleaner, allows more code reuse
	@Pointcut("execution(* com.jake.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		System.out.println("Test");
	}
	
	@Pointcut("execution(* com.jake.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.jake.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// point cuts can be combined
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>>>> Executing @before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>>>> Peforming API analytics...");
	}

}
