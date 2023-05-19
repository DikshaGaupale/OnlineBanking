package com.example.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CustomerException;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	 CustomerRepository customerRepository;
	 
	

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		
		return customerRepository.findAll();
		
	}

	@Override
	public Customer getCustomerById(String customerId) throws CustomerException {
		
		 return customerRepository.findById(customerId).orElseThrow(() -> new CustomerException("Customer not found"));
	}

	@Override
	public Customer deletCustomerById(String customerId) throws CustomerException {
		
		Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerException("Customer not found"));

        customerRepository.delete(customer);

        return customer;
	}

}
