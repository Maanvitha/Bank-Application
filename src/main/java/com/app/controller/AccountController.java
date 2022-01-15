package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
public class AccountController {
	
	@Autowired(required=true)
	AccountService accService;
	
	@GetMapping("/sample")
	public String sample() 
	{
		return "sample";
	}
	
	@PostMapping("/addAccount")
	public  String addAccount(@RequestBody Account a) {
		return accService.addAccount(a);
		 
	}
	
	@GetMapping("/getAllAccountDetails")
	public List<Account> getAllAccount(){
		return accService.getAllAccount();
		
	}
	
	@GetMapping("/TransferFunds/{from}/{to}/{amount}")
	public String transferFunds(@PathVariable(value="from") int from,@PathVariable(value="to") int to, @PathVariable(value="amount") double amount) {

		return accService.transferFunds(from, to, amount);
	}
	
	@GetMapping("/getBalance/{accno}")
	public Account getBalanceOf(@PathVariable(value="accno") int accno) {
		
		return accService.getBalanceOf(accno);
	}
	
	@PutMapping("/updateAccount/{id}/{balance}")
	public Account updateAccount(@PathVariable(value="id") int id,@PathVariable(value="balance") float balance)
	{
		return accService.updateAccount(id,balance);
		
	}
	
	@DeleteMapping("/deleteAccount")
	public String deleteAccount()
	{
		return accService.deleteAccounts();
		
	}

}
