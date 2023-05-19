package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.TransactionException;
import com.example.model.Account;
import com.example.model.Transaction;
import com.example.repository.TransactionRepository;



public interface TransactionService{

public Transaction transferMoney(String sourceAccountNumber, String destinationAccountNumber, double amount) throws TransactionException;
	
	public Transaction withdrawMoney(String accountNumber, double amount) throws TransactionException;
	
	public Transaction depositMoney(String accountNumber, double amount) throws TransactionException;
}
