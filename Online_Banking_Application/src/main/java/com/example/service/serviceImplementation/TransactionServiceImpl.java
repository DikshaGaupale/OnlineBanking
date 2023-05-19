package com.example.service.serviceImplementation;

import com.example.exception.TransactionException;
import com.example.model.Transaction;






import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.TransactionException;
import com.example.model.Account;
import com.example.model.Transaction;
import com.example.repository.TransactionRepository;
import com.example.service.AccountService;
import com.example.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	 TransactionRepository transactionRepository;
	
	@Autowired
     AccountService accountService;

	@Override
	public Transaction transferMoney(String sourceAccountNumber, String destinationAccountNumber, double amount)
			throws TransactionException {
		
		// Get the source and destination accounts
        Account sourceAccount = accountService.getAccountByAccountNumber(sourceAccountNumber);
        Account destinationAccount = accountService.getAccountByAccountNumber(destinationAccountNumber);

        // Validate transfer amount
        if (amount <= 0) {
            throw new TransactionException("Transfer amount must be greater than zero.");
        }

        // Check if the source account has sufficient balance
        double sourceAccountBalance = sourceAccount.getBalance();
        if (sourceAccountBalance < amount) {
            throw new TransactionException("Insufficient balance in the source account.");
        }

        // Perform the transfer
        double destinationAccountBalance = destinationAccount.getBalance();
        sourceAccount.setBalance(sourceAccountBalance - amount);
        destinationAccount.setBalance(destinationAccountBalance + amount);
        Transaction transaction = new Transaction();
        transaction.setTransactionType("Transfer");
        transaction.setAmount(amount);
        transaction.setDate((java.sql.Date) new Date());
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destinationAccount);
        transactionRepository.save(transaction);
        accountService.updateAccount(sourceAccount);
        accountService.updateAccount(destinationAccount);

        return transaction;
	}

	@Override
	public Transaction withdrawMoney(String accountNumber, double amount) throws TransactionException {
		
		// Get the account
        Account account = accountService.getAccountByAccountNumber(accountNumber);

        // Validate withdrawal amount
        if (amount <= 0) {
            throw new TransactionException("Withdrawal amount must be greater than zero.");
        }

        // Check if the account has sufficient balance
        double accountBalance = account.getBalance();
        if (accountBalance < amount) {
            throw new TransactionException("Insufficient balance in the account.");
        }

        // Perform the withdrawal
        account.setBalance(accountBalance - amount);
        Transaction transaction = new Transaction();
        transaction.setTransactionType("Withdrawal");
        transaction.setAmount(amount);
        transaction.setDate((java.sql.Date) new Date());
        transaction.setSourceAccount(account);
        transactionRepository.save(transaction);
        accountService.updateAccount(account);

        return transaction;
	}

	@Override
	public Transaction depositMoney(String accountNumber, double amount) throws TransactionException {
		
		// Get the account
        Account account = accountService.getAccountByAccountNumber(accountNumber);

        // Validate deposit amount
        if (amount <= 0) {
            throw new TransactionException("Deposit amount must be greater than zero.");
        }

        // Perform the deposit
        double accountBalance = account.getBalance();
        account.setBalance(accountBalance + amount);
        Transaction transaction = new Transaction();
        transaction.setTransactionType("Deposit");
        transaction.setAmount(amount);
        transaction.setDate((java.sql.Date) new Date());
        transaction.setDestinationAccount(account);
        transactionRepository.save(transaction);
        accountService.updateAccount(account);

        return transaction;
	}
	
	
	
}
