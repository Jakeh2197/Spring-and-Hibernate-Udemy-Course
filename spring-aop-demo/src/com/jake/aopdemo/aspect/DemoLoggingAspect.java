package com.jake.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	// add code for related advices
	
	// @Before runs before the method
	// Use this to test various @Before implementations (wildcards, parameters etc.)
	@Before("execution(* com.jake.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("========>>>>> Executing @Before advice on addAccount() method...");
	}

}
