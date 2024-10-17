package com.banking.banking_system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.banking.banking_system.entity.User;
import com.banking.banking_system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String username, @RequestParam String password,@RequestParam String fullname, @RequestParam String Address, @RequestParam String branchId) {
        try {
            userService.registerUser(username, password, fullname, Address, branchId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/login");
        return mav;
    }


    
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
       Optional<User> userOptional = userService.findByUsername(username);
    if (userOptional.isPresent()) { 
            User user = userOptional.get();
           if (user.getPassword().equals(password)) {
               ModelAndView mav = new ModelAndView("redirect:/accounts");
               return mav;
           } else {
               ModelAndView mav = new ModelAndView("login");
               mav.addObject("error", "Invalid username or password");
               return mav;
           }
       } else {
           ModelAndView mav = new ModelAndView("login");
           mav.addObject("error", "User  not found");
           return mav;
       }
    }
    
}
