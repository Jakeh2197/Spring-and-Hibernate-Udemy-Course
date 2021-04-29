package com.jake.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jake.aopdemo.dao.AccountDAO;
import com.jake.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from srping container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// create objects for parameters
		Account account = new Account();
		
		account.setName("Jake");
		account.setLevel("At Least 12");
		
		// call the methods
		accountDAO.addAccount(account);
		accountDAO.doStuff();
		
		System.out.println(membershipDAO.addMember());
		membershipDAO.doWork();
		
		// close the context
		context.close();
	}

}