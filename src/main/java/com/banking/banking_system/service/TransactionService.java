package com.banking.banking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.Transaction;
import com.banking.banking_system.repo.AccountRepository;
import com.banking.banking_system.repo.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Transaction deposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        
        Transaction transaction = new Transaction("DEPOSIT", amount, account);
        return transactionRepository.save(transaction);
    }

    public Transaction withdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);
            
            Transaction transaction = new Transaction("WITHDRAWAL", amount, account);
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

	
}
