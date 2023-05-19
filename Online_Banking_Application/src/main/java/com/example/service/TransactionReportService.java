package com.example.service;

import java.util.List;

import com.example.exception.TransactionReportException;
import com.example.model.TransactionReport;

public interface TransactionReportService {

	
    public TransactionReport createTransactionReport(TransactionReport transactionReport);

   
    public List<TransactionReport> getAllTransactionReports();

   
    public TransactionReport getTransactionReportById(String reportId) throws TransactionReportException;
   
    public TransactionReport deleteTransactionReportById(String reportId) throws TransactionReportException; 
    

}
