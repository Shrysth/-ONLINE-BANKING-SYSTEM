package com.banking.banking_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.User;
import com.banking.banking_system.service.AccountService;
import com.banking.banking_system.service.UserService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;  // Correctly autowire the UserService

    @PostMapping("/create")
    public Account createAccount(@RequestParam Long userId, @RequestParam String accountType) {
        User user = userService.findById(userId).orElseThrow();  // Use the userService instance
        return accountService.createAccount(user, accountType);
    }

    @GetMapping("/user/{userId}")
    public List<Account> getAccountsByUser(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow();  // Use the userService instance
        return accountService.getAccountsByUser(user);
    }
}
