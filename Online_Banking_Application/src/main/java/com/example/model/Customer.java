package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;


@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
public class Customer {

	@Id
	
    private String customerId;
	
	@NotNull(message = "Name Cannot be empty or blank or null")
    @NotEmpty(message = "Name Cannot be empty or blank or null")
    @NotBlank(message = "Name Cannot be empty or blank or null")
    @Size(min = 6,max = 20, message = "Name should be 6to 20 letters")
    private String name;
	
	@NotBlank(message = "Contact information is required.")
    @Pattern(regexp = "\\d{10}", message = "Contact information must be a 10-digit number.")
    private String contactInformation;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;
}
