package com.jake.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jake.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		
		// create sample accounts
		Account one = new Account("John", "Silver");
		Account two = new Account("Jake", "Platinum");
		Account three = new Account("Chelsea", "Gold");
		
		// add accounts to list
		accounts.add(one);
		accounts.add(two);
		accounts.add(three);
		
		return accounts;
	}
	
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
