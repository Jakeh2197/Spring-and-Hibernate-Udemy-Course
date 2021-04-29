package com.jake.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class CloudLoggingAspect {
	
	@Before("com.jake.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println("=====>>>>> Logging to cloud...");
	}
	
}
