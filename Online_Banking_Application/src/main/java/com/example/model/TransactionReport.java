package com.example.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class TransactionReport {

	    @Id
	    private String reportId;
	    
	    @NotNull(message = "ReportType Cannot be empty or blank or null")
	    @NotEmpty(message = "ReportType Cannot be empty or blank or null")
	    @NotBlank(message = "ReportType Cannot be empty or blank or null")
	    private String reportType;
	    
	    @Temporal(TemporalType.DATE)
	    @NotBlank(message = "Date range is required.")
	    private Date dateRange;
	    
	    @NotNull(message = "summary Cannot be empty or blank or null")
	    @NotEmpty(message = "summary Cannot be empty or blank or null")
	    @NotBlank(message = "summary Cannot be empty or blank or null")
	    private String summary;
}
