package com.app.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.Customer;

@Service
public interface AccountService {
	
	public String addAccount(Account acc);
	public List<Account> getAllAccount();
	public String transferFunds(int from,int to,double amount);
	public Account getBalanceOf(int accountNumber);
	public Account updateAccount(int id, float balance);
	public String deleteAccounts();


}
