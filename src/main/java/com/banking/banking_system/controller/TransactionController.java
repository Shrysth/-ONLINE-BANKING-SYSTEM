package com.banking.banking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.entity.Transaction;
import com.banking.banking_system.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public Transaction deposit(@RequestParam Long accountId, @RequestParam Double amount) {
        return transactionService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestParam Long accountId, @RequestParam Double amount) {
        return transactionService.withdraw(accountId, amount);
    }
}

