package com.example.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import com.example.exception.AccountException;
import com.example.model.Account;
import com.example.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	 AccountRepository accountRepository;
	
	 @Autowired
	 TransactionRepository transactionRepository;
	
	@Override
	public Account createAccount(Account account) {
		
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		
		return accountRepository.findById(accountNumber)
                .orElseThrow(() -> new AccountException("Account not found"));
	}

	@Override
	public Account deleteAccountByAccountNumber(String accountNumber) {
		
		Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new AccountException("Account not found"));

        accountRepository.delete(account);

        return account;
	}
	
	@Override
    public void updateAccount(Account sourceAccount) {
        // Call the repository method to update the account
        transactionRepository.saveAll(sourceAccount);
    }

}
