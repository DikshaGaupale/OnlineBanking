package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.TransactionException;
import com.example.model.Transaction;
import com.example.service.TransactionService;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transferMoney(
            @RequestParam("sourceAccountNumber") String sourceAccountNumber,
            @RequestParam("destinationAccountNumber") String destinationAccountNumber,
            @RequestParam("amount") double amount) {
        try {
            Transaction transaction = transactionService.transferMoney(sourceAccountNumber, destinationAccountNumber, amount);
            return ResponseEntity.ok(transaction);
        } catch (TransactionException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdrawMoney(
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("amount") double amount) {
        try {
            Transaction transaction = transactionService.withdrawMoney(accountNumber, amount);
            return ResponseEntity.ok(transaction);
        } catch (TransactionException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> depositMoney(
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("amount") double amount) {
        try {
            Transaction transaction = transactionService.depositMoney(accountNumber, amount);
            return ResponseEntity.ok(transaction);
        } catch (TransactionException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
