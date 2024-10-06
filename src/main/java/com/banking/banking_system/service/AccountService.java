package com.banking.banking_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.User;
import com.banking.banking_system.repo.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(User user, String accountType) {
        Account account = new Account(accountType, user);
        return accountRepository.save(account);
    }

    public List<Account> getAccountsByUser(User user) {
        return accountRepository.findByUser(user);
    }

}


