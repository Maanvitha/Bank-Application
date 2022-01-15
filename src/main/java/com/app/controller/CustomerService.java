package com.app.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Customer;

@Service
public interface CustomerService {
	
	List<Customer> getAllCustomer();

	String addCustomer(Customer acc);

	Customer updateCustomer(String name, float balance);

	String deleteCustomer(int cusNo);

	String deleteAllCustomer();

}
