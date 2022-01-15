package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Account;
import com.app.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cusService;
	
	
	@PostMapping("/addCustomer")
	public  String addAccount(@RequestBody Customer c) {
		return cusService.addCustomer(c);
		 
	}
	
	
	@GetMapping("/getAllCustomerDetails")
	public List<Customer> getAllCustomer(){
		return cusService.getAllCustomer();
		
	}
	
	@PutMapping("/updateCustomer/{name}/{balance}")
	public Customer updateCustomer(@PathVariable(value="name") String name,@PathVariable(value="balance") float balance)
	{
		return cusService.updateCustomer(name,balance);
		
	}
	
	@DeleteMapping("/deleteCustomer/{cusNo}")
	public String deleteCustomer(@PathVariable(value="cusNo") int cusNo)
	{
		return cusService.deleteCustomer(cusNo);
		
	}
	
	@DeleteMapping("/deleteAllCustomer")
	public ResponseEntity<String> deleteAllCustomer()
	{
		String a=cusService.deleteAllCustomer();
		return  ResponseEntity.ok("Deleted");
	
	}

}
