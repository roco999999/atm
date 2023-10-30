package com.atm.atmdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atm.atmdemo.model.Account;
import com.atm.atmdemo.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account deposit(int accountId, Double amount) {
        // Hesap bilgisini çek
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Hesap bulunamadı"));
        
        // Yeni bakiyeyi hesapla
        double newBalance = account.getBalance() + amount;
        
        // Bakiyeyi güncelle
        account.setBalance(newBalance);
        
        // Güncellenen hesabı kaydet
        return accountRepository.save(account);
    }

    public Account withdraw(int accountId, Double amount) {
        // Hesap bilgisini çek
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Hesap bulunamadı"));

        // Yeterli bakiye olup olmadığını kontrol et
        if (account.getBalance() < amount) {
            throw new RuntimeException("Yetersiz bakiye");
        }

        // Yeni bakiyeyi hesapla
        double newBalance = account.getBalance() - amount;

        // Bakiyeyi güncelle
        account.setBalance(newBalance);

        // Güncellenen hesabı kaydet
        return accountRepository.save(account);
    }

    public Account createAccount(String name, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Negatif bakiye girilemez.");
        }

        Account newAccount = new Account();
        newAccount.setName(name);
        newAccount.setBalance(balance);

        return accountRepository.save(newAccount);
    }

    public Account getAccount(int accountId) {
        return accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalArgumentException("Bu ID'ye ait hesap yok: " + accountId));
    }
    
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    public void deleteAccount(int accountId) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalArgumentException("Bu ID'ye ait hesap yok: " + accountId));
        accountRepository.delete(account);
    }

}

