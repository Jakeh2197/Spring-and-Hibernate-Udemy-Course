package com.jake.springdemo.dao;

import java.util.List;

import com.jake.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
