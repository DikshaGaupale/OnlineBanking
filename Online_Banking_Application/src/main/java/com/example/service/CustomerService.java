package com.example.service;

import java.util.List;

import com.example.exception.CustomerException;
import com.example.model.Customer;

public interface CustomerService {

	

    public List<Customer> getAllCustomers() throws CustomerException;

    public Customer getCustomerById(String customerId) throws CustomerException;
    
    public Customer deletCustomerById(String customerId) throws CustomerException;
}
