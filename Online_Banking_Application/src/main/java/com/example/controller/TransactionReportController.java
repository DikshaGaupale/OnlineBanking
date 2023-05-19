package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.TransactionReportException;
import com.example.model.TransactionReport;
import com.example.service.TransactionReportService;


@RestController
@RequestMapping("/transaction-reports")
public class TransactionReportController {

    @Autowired
    private TransactionReportService transactionReportService;

    @PostMapping
    public ResponseEntity<TransactionReport> createTransactionReport(@RequestBody TransactionReport transactionReport) {
        TransactionReport createdReport = transactionReportService.createTransactionReport(transactionReport);
        return ResponseEntity.ok(createdReport);
    }

    @GetMapping
    public ResponseEntity<List<TransactionReport>> getAllTransactionReports() {
        List<TransactionReport> transactionReports = transactionReportService.getAllTransactionReports();
        return ResponseEntity.ok(transactionReports);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<TransactionReport> getTransactionReportById(@PathVariable String reportId) {
        try {
            TransactionReport transactionReport = transactionReportService.getTransactionReportById(reportId);
            return ResponseEntity.ok(transactionReport);
        } catch (TransactionReportException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteTransactionReportById(@PathVariable String reportId) {
        try {
            TransactionReport transactionReport = transactionReportService.deleteTransactionReportById(reportId);
            return ResponseEntity.noContent().build();
        } catch (TransactionReportException e) {
            return ResponseEntity.notFound().build();
        }
    }
}