package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
   
	@Query
	("select a from Account a where a.accountNumber =?1")
		
	public Account getAccountByAccountNumber(String accountNumber);
		
		
		
		@Query("select a from Account a ")
		public List<Account> getAllAccounts();
}