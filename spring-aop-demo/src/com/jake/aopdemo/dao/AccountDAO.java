package com.jake.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.jake.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account account) {
		System.out.println(getClass() + ": Doing DB work: Adding account...\n");
	}
	
	public boolean doStuff() {
		System.out.println(getClass() + ": Doing some stuff...\n");
		
		return true;
	}
}
