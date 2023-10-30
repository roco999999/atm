package com.atm.atmdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Transaction> processTransaction(
            @RequestParam int accountId,
            @RequestParam double amount,
            @RequestParam String type) {
        Transaction transaction = transactionService.processTransaction(accountId, amount, type);
        return ResponseEntity.ok(transaction);
    }
}
