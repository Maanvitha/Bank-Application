package com.app.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Account;
import com.app.model.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
	
	Account findById(int accountNo);

	

}
