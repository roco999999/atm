package com.atm.atmdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atm.atmdemo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}

