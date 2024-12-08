package com.banking.banking_system.controller;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

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
    public String AccountsPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        String fullname = (String) session.getAttribute("fullname");
        String Address = (String) session.getAttribute("Address");
        String branchId = (String) session.getAttribute("branchId");
        String branchName = (String) session.getAttribute("branchName");
        model.addAttribute("username", username);
        model.addAttribute("fullname", fullname);
        model.addAttribute("Address", Address);
        model.addAttribute("branchId", branchId);
        model.addAttribute("branchName", branchName);
        return "accounts";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }    
}
