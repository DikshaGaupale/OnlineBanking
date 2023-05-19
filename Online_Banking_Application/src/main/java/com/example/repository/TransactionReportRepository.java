package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.exception.TransactionReportException;
import com.example.model.TransactionReport;

@Repository
public interface TransactionReportRepository extends JpaRepository<TransactionReport, String> {
    
	@Query("select t from TransactionReport t ")
	public List<TransactionReport> getAllTransactionReports();

	@Query
	("select t from TransactionReport t where t.reportId =?1") 
    public TransactionReport getTransactionReportById(String reportId) ;
}
