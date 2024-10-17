package com.banking.banking_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.User;
import com.banking.banking_system.service.AccountService;
import com.banking.banking_system.service.UserService;

@Controller
public class FrontendController {

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @GetMapping("/transaction")
    public String showTransactionForm() {
        return "transaction";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/accounts")
    public String showAccountsPage() {
        return "accounts";
    }
    

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @Autowired
    private UserService userService;
    private AccountService accountService;

    
}
