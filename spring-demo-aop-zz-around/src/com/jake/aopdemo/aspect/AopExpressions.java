package com.jake.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	// @Pointcut is used to declare pointcut expressions
	// this makes refactoring simpler, code cleaner, allows more code reuse
	@Pointcut("execution(* com.jake.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
		System.out.println("Test");
	}
	
	@Pointcut("execution(* com.jake.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.jake.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// point cuts can be combined
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
