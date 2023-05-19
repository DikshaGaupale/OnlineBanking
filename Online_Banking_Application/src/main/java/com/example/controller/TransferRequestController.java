package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.TransferRequest;
import com.example.service.TransferRequestService;


@RestController
@RequestMapping("/transfer-requests")
public class TransferRequestController {

    @Autowired
    private TransferRequestService transferRequestService;

    @PostMapping("/create")
    public ResponseEntity<TransferRequest> createTransferRequest(@RequestBody TransferRequest transferRequest) {
        try {
            TransferRequest createdTransferRequest = transferRequestService.createTransfer(transferRequest);
            return ResponseEntity.ok(createdTransferRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (InsufficientAuthenticationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}
