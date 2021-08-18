package com.jake.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.jake.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing DB work: Adding account...\n");
	}
	
	public boolean doStuff() {
		System.out.println(getClass() + ": Doing some stuff...\n");
		
		return true;
	}

	public String getName() {
		System.out.println("Inside name getter");
		return name;
	}

	public void setName(String name) {
		System.out.println("Inside name setter");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("Inside serviceCode getter");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("Inside serviceCode setter");
		this.serviceCode = serviceCode;
	}
	
	
}
