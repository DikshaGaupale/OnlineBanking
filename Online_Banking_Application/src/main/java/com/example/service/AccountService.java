package com.example.service;

import java.util.List;

import com.example.model.Account;

public interface AccountService {

	public Account createAccount(Account account);

    public List<Account> getAllAccounts();

    public Account getAccountByAccountNumber(String accountNumber);
    
    public Account deleteAccountByAccountNumber(String accountNumber);
    
	public void updateAccount(Account sourceAccount); 
}
