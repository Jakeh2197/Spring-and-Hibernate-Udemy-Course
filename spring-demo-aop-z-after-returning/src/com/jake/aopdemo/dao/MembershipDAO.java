package com.jake.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public String addMember() {
		return (getClass() + ": Adding membership account...\n");
	}
	
	public void doWork() {
		System.out.println(getClass() + ": Doing some work...\n");
	}
}
