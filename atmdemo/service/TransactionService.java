package com.atm.atmdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.atm.atmdemo.model.Account;
import com.atm.atmdemo.model.Transaction;
import com.atm.atmdemo.repository.AccountRepository;
import com.atm.atmdemo.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }
    
    
    public Transaction processTransaction(int accountId, double amount, String type) {
    	
        Account account = null;
        
        // İşlem türüne göre işlemi gerçekleştir
        if ("DEPOSIT".equals(type)) {
            account = accountService.deposit(accountId, amount);
        } else if ("WITHDRAW".equals(type)) {
            account = accountService.withdraw(accountId, amount);
        } else {
            throw new RuntimeException("Geçersiz islem turu.");
        }
        
        // Yeni işlem oluştur
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setType(type);
        
        // İşlemi kaydet
        return transactionRepository.save(transaction);
    }
    
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

