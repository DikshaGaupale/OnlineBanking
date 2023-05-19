package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Account;
import com.example.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Account> deleteAccountByAccountNumber(@PathVariable String accountNumber) {
        Account deletedAccount = accountService.deleteAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(deletedAccount);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<Void> updateAccount(@PathVariable String accountNumber, @RequestBody Account account) {
        Account existingAccount = accountService.getAccountByAccountNumber(accountNumber);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }

        account.setAccountNumber(accountNumber);
        accountService.updateAccount(account);

        return ResponseEntity.noContent().build();
    }
}
