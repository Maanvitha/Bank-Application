package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.Customer;

@Service
public class AccountServiceImplementation implements AccountService {

	@Autowired
	AccountRepository repo;
	
	@Override
	public String addAccount(Account acc) {
		repo.save(acc);
		return "Account Added";
	}

	@Override
	public List<Account> getAllAccount() {
		return repo.findAll();
	}

	@Override
	public String transferFunds(int from, int to, double amount) {
		Account a1= repo.findById(from);
		Account a2=repo.findById(to);
		try {
		//Account a1=op1.get();
		//Account a2=op2.get();
		if(a1.balance<=amount)
		{
			return "INSUFFICIENT FUNDS";
			
		}
		else if(a1.balance>amount)
		{
			a2.balance+=amount;
			a1.balance-=amount;
			repo.save(a1);
			repo.save(a2);
			return "SUCCESS";
		}
		}
		catch(RuntimeException e) {
			return "ID MISMATCH";
		}
		return null;
	}

	@Override
	public Account getBalanceOf(int accountNumber)
	{
		
			try {
			System.out.println("In balance");
			Account op1= repo.findById(accountNumber);
			return op1;
		}catch(RuntimeException e) {
			System.out.println("not found");
		}
		return null;

	}

	@Override
	public Account updateAccount(int id, float balance) {
		try {
			Account op1= repo.findById(id);
			
			op1.setBalance(balance);
			repo.save(op1);
			return op1;
		}catch(RuntimeException e) {
			System.out.println("not found");
		}
		return null;
	
	}

	@Override
	public String deleteAccounts() {
		repo.deleteAll();
		return "true";
	}

}
