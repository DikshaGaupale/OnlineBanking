package com.example.exception;

import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException me, WebRequest req){
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    
    
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException ne, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ne.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> adminException(AccountException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ErrorDetails> bookingException(CustomerException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleException.class)
    public ResponseEntity<ErrorDetails> busException(RoleException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErrorDetails> customerException(TransactionException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionReportException.class)
    public ResponseEntity<ErrorDetails> feedbackException(TransactionReportException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransferRequestException.class)
    public ResponseEntity<ErrorDetails> hotelException(TransferRequestException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> packageException(UserException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

   
}
