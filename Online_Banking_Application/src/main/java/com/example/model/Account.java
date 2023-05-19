package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import jakarta.validation.constraints.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
public class Account {

	    @Id
	   
	    @NotNull(message = "AccountNumber Cannot be empty or blank or null")
	    @NotEmpty(message = "AccountNumber Cannot be empty or blank or null")
	    @NotBlank(message = "AccountNumber Cannot be empty or blank or null")
	    @Size(min = 8, max = 15, message = "AccountNumber should be 8 to 15 letters")
	    private String accountNumber;
	    
	    
	    @Min(value = 10000, message = "Minimum balance of Rs 10,000 is required.")
	    @NotNull(message = "Account Balance Cannot be empty or blank or null")
	    @NotEmpty(message = "Account Balance Cannot be empty or blank or null")
	    @NotBlank(message = "Account Balance Cannot be empty or blank or null")
	    private double balance;
	    
	    @NotBlank(message = "Account type is required.")
	    private String accountType;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @OneToMany(mappedBy = "sourceAccount", cascade = CascadeType.ALL)
	    private List<Transaction> outgoingTransactions;

	    @OneToMany(mappedBy = "destinationAccount", cascade = CascadeType.ALL)
	    private List<Transaction> incomingTransactions;
}
