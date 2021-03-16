package com.jake.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jake.springdemo.dao.CustomerDAO;
import com.jake.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO dao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}
}
