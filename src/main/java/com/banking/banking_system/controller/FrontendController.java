package com.banking.banking_system.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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

    @GetMapping("/accounts")
    public String showAccountsPage(Model model) {
        return "accounts";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
