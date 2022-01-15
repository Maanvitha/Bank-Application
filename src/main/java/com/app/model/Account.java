package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement
@Entity
@Table(name="Account")
public class Account {
	
	public String accountType;
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	public int accountNo;
	public float balance;
	
	@JsonIgnore
	@OneToOne(mappedBy="account")  
	public Customer customer;
	
	
	public Account() {}
	
	public Account(String  accountType, float balance) {
		// TODO Auto-generated constructor stub
	}


	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	

}
