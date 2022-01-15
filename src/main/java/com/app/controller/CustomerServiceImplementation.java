package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	
	@Override
	public String addCustomer(Customer acc) {
		repo.save(acc);
		return "Customer Added";
	}
	
	
	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}


	@Override
	public Customer updateCustomer(String name, float balance) {
		try {
			Customer op1= repo.findByName(name);
			System.out.println(op1.getName());
			Account a=op1.getAccount();
			System.out.println(a.getBalance());
			a.setBalance(balance);
			repo.save(op1);
			return op1;
		}catch(RuntimeException e) {
			System.out.println("not found");
		}
		return null;
	}


	@Override
	public String deleteCustomer(int cusNo) {
		try {
			Optional<Customer> op1=repo.findById(cusNo);
			Customer c=op1.get();
			repo.delete(c);
			return "Deleted";
		}catch(RuntimeException e){
			System.out.println("Customer not found");
		}
		return null;
	}


	@Override
	public String deleteAllCustomer() {
		repo.deleteAll();
		return "true";
	}

}
