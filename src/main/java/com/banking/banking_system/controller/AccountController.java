package com.banking.banking_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.User;
import com.banking.banking_system.service.AccountService;
import com.banking.banking_system.service.UserService;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService; // Correctly autowire the UserService

    
    @GetMapping("/")
    public String showAccountsPage(@RequestParam String username, Model model) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            return "accounts"; // This should return the name of your accounts Thymeleaf template
        } else {
            model.addAttribute("error", "User not found");
            return "error"; // Or redirect to a custom error page
        }
    }

    @GetMapping("/create")
    public ModelAndView showUserAccountsPage() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

}