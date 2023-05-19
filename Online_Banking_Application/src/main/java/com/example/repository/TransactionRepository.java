package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	void saveAll(Account sourceAccount);
    // For the transferMoney method:
	
	
	@Modifying
	@Query(value = "UPDATE Account SET balance = balance - :amount WHERE account_number = :sourceAccountNumber", nativeQuery = true)
	void updateSourceAccountBalance(@Param("sourceAccountNumber") String sourceAccountNumber, @Param("amount") double amount);

	@Modifying
	@Query(value = "UPDATE Account SET balance = balance + :amount WHERE account_number = :destinationAccountNumber", nativeQuery = true)
	void updateDestinationAccountBalance(@Param("destinationAccountNumber") String destinationAccountNumber, @Param("amount") double amount);

	@Modifying
	@Query(value = "INSERT INTO Transaction (transaction_type, amount, date, source_account_number, destination_account_number) " +
	        "VALUES ('Transfer', :amount, CURRENT_TIMESTAMP, :sourceAccountNumber, :destinationAccountNumber)", nativeQuery = true)
	void createTransferTransaction(@Param("amount") double amount, @Param("sourceAccountNumber") String sourceAccountNumber, @Param("destinationAccountNumber") String destinationAccountNumber);
	
	
	
	
	//For the withdrawMoney method:
	
	@Modifying
	@Query(value = "UPDATE Account SET balance = balance - :amount WHERE account_number = :accountNumber", nativeQuery = true)
	void updateAccountBalanceForWithdrawal(@Param("accountNumber") String accountNumber, @Param("amount") double amount);

	@Modifying
	@Query(value = "INSERT INTO Transaction (transaction_type, amount, date, source_account_number) " +
	        "VALUES ('Withdrawal', :amount, CURRENT_TIMESTAMP, :accountNumber)", nativeQuery = true)
	void createWithdrawalTransaction(@Param("amount") double amount, @Param("accountNumber") String accountNumber);
	
	
	//For the depositMoney method:
	
	@Modifying
	@Query(value = "UPDATE Account SET balance = balance + :amount WHERE account_number = :accountNumber", nativeQuery = true)
	void updateAccountBalanceForDeposit(@Param("accountNumber") String accountNumber, @Param("amount") double amount);

	@Modifying
	@Query(value = "INSERT INTO Transaction (transaction_type, amount, date, destination_account_number) " +
	        "VALUES ('Deposit', :amount, CURRENT_TIMESTAMP, :accountNumber)", nativeQuery = true)
	void createDepositTransaction(@Param("amount") double amount, @Param("accountNumber") String accountNumber);
	
	
}