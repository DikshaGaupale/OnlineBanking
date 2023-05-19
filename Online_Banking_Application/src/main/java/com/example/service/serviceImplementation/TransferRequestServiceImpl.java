package com.example.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import com.example.model.TransferRequest;
import com.example.repository.TransferRequestRepository;
import com.example.service.TransferRequestService;

@Service
public class TransferRequestServiceImpl implements TransferRequestService{

	@Autowired
	 TransferRequestRepository  transferRequestRepository ;
	
	@Override
	public TransferRequest createTransfer(TransferRequest transfer) {
	    // Perform necessary validations

	    // Check if the transfer amount is positive
	    if (transfer.getTransferAmount() <= 0) {
	        throw new IllegalArgumentException("Transfer amount must be positive.");
	    }

	    // Check if the source and destination accounts are different
	    if (transfer.getSourceAccount().equals(transfer.getDestinationAccount())) {
	        throw new IllegalArgumentException("Source and destination accounts must be different.");
	    }

	    // Check if the source account has sufficient balance
	    if (transfer.getTransferAmount() > transfer.getSourceAccount().getBalance()) {
	        throw new InsufficientAuthenticationException("Insufficient balance in the source account.");
	    }

	    // Perform business logic

	    // Subtract the transfer amount from the source account balance
	    double updatedSourceBalance = transfer.getSourceAccount().getBalance() - transfer.getTransferAmount();
	    transfer.getSourceAccount().setBalance(updatedSourceBalance);

	    // Add the transfer amount to the destination account balance
	    double updatedDestinationBalance = transfer.getDestinationAccount().getBalance() + transfer.getTransferAmount();
	    transfer.getDestinationAccount().setBalance(updatedDestinationBalance);

	    // Save the transfer to the repository
	    return transferRequestRepository.save(transfer);
	}
}