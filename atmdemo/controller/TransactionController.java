package com.atm.atmdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atm.atmdemo.dto.TransactionRequest;
import com.atm.atmdemo.model.Transaction;
import com.atm.atmdemo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/process")
    public ResponseEntity<Transaction> processTransaction(@RequestBody TransactionRequest request) {
        Transaction transaction = transactionService.processTransaction(request.getAccountId(),request.getAmount(),request.getType());
        return ResponseEntity.ok(transaction);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

}
