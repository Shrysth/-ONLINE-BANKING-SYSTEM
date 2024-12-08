package com.banking.banking_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.User;
import com.banking.banking_system.service.AccountService;
import com.banking.banking_system.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService; // Correctly autowire the UserService

    @GetMapping("/show")
    public String showAccountsPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        String fullname = (String) session.getAttribute("fullname");
        String Address = (String) session.getAttribute("Address");
        String branchId = (String) session.getAttribute("branchId");
        String branchName = (String) session.getAttribute("branchName");
        java.util.List<Account> l1 = (List) session.getAttribute("account");
        model.addAttribute("username", username);
        model.addAttribute("fullname", fullname);
        model.addAttribute("Address", Address);
        model.addAttribute("branchId", branchId);
        model.addAttribute("branchName", branchName);
        model.addAttribute("account", l1);
        return "ShowAccounts";
    }

    // @PostMapping("/show")
    // public ModelAndView showAccountsPage( Model model, HttpSession session) {
    //     String username= (String) session.getAttribute("username");
    //     // Optional<User> user = userService.findByUsername(username);
    //     // if (user.isPresent()) {
    //         User u = userService.findByusername(username);
    //         List<Account> l1 = AccountService.getAccountsByUser(u);
    //         session.setAttribute("account", l1);
    //         ModelAndView mav = new ModelAndView("showAccounts");
    //         return mav; // This should return the name of your accounts Thymeleaf template
    //     // } else {
    //     //     ModelAndView mav = new ModelAndView("login");
    //     //    mav.addObject("error", "User  not found");
    //     //    return mav;
    //     // }
    // }

    @GetMapping("/create")
    public ModelAndView showCreateAccountsPage(HttpSession session, Model model) {
        ModelAndView mav = new ModelAndView("createAccounts");
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
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView showCreateAccountsPage(HttpSession session, Model model, @RequestParam String accountType) {
        if("Current".equals(accountType)){
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
        Optional<User> userOptional = userService.findByUsername(username);
        User user = userOptional.get();
        Account account = new Account("Current", user);
        ModelAndView mav = new ModelAndView("Accounts");
        return mav;
    }
    if("Savings".equals(accountType)){
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
        Optional<User> userOptional = userService.findByUsername(username);
        User user = userOptional.get();
        Account account = new Account("Savings", user);
        ModelAndView mav = new ModelAndView("Accounts");
        return mav;
    }
    else {
        ModelAndView mav = new ModelAndView("error");
        return mav;
    }
}
}