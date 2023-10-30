package com.atm.atmdemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.atm.atmdemo.model.Account;
import com.atm.atmdemo.repository.AccountRepository;
import com.atm.atmdemo.service.AccountService;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testCreateAccount() {
        // Mock data
        String name = "Test";
        double balance = 100.0;

        // Mock behavior
        when(accountRepository.save(any(Account.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        // Call the method to test
        Account createdAccount = accountService.createAccount(name, balance);

        // Assertions
        assertNotNull(createdAccount);
        assertEquals(name, createdAccount.getName());
        assertEquals(balance, createdAccount.getBalance());
    }
}

