package com.example.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.TransactionReportException;
import com.example.model.TransactionReport;
import com.example.repository.TransactionReportRepository;
import com.example.service.TransactionReportService;

@Service
public class TransactionReportServiceImpl implements TransactionReportService{

	 @Autowired
	 TransactionReportRepository transactionReportRepository;
	 
	 
	 @Override
	    public TransactionReport createTransactionReport(TransactionReport transactionReport) {
	        
	        return transactionReportRepository.save(transactionReport);
	    }

	    @Override
	    public List<TransactionReport> getAllTransactionReports() {
	        // Retrieve all transaction reports from the repository
	        return transactionReportRepository.findAll();
	    }

	    @Override
	    public TransactionReport getTransactionReportById(String reportId) throws TransactionReportException {
	        // Retrieve a transaction report by its report ID
	        return transactionReportRepository.findById(reportId)
	                .orElseThrow(() -> new TransactionReportException("Transaction report not found with ID: " + reportId));
	    }

	    @Override
	    public TransactionReport deleteTransactionReportById(String reportId) throws TransactionReportException {
	        // Delete a transaction report by its report ID
	        TransactionReport transactionReport = getTransactionReportById(reportId);
	        transactionReportRepository.delete(transactionReport);
	        return transactionReport;
	    }

}
