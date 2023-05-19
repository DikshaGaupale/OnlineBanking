package com.example.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
public class Transaction {

	
	@Id
	
    private String transactionId;
	
    private String transactionType;
    private double amount;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "source_account_number")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_number")
    private Account destinationAccount;
}
