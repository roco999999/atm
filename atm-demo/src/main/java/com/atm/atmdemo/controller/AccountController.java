package com.atm.atmdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atm.atmdemo.model.Account;
import com.atm.atmdemo.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam String name, @RequestParam double balance) {
        Account createdAccount = accountService.createAccount(name, balance);
        return ResponseEntity.ok(createdAccount);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable int accountId) {
        Account account = accountService.getAccount(accountId);
        return ResponseEntity.ok(account);
    }
}
