package com.atm.atmdemo.dto;

public class AccountRequest {

    private String name;
    private double balance;

    // Getter ve setter metodları

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

