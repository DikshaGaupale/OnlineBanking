package com.example.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "password"))
public class User {

	@Id
    private String username;
	
	@NotNull(message = "password Cannot be empty or blank or null")
    @NotEmpty(message = "password Cannot be empty or blank or null")
    @NotBlank(message = "password Cannot be empty or blank or null")
	@Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_name")
    private Role role;
}
