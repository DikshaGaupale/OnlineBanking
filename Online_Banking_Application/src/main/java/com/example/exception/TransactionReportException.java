package com.example.exception;

public class TransactionReportException extends RuntimeException{

	public TransactionReportException(String message) {
        super(message);
    }
}
