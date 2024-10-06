package com.banking.banking_system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountType;
    private Double balance = 0.0;

    @ManyToOne
    private User user;

    // Constructor with accountType and user
    public Account(String accountType, User user) {
        this.accountType = accountType;
        this.user = user;
        this.balance = 0.0; // Default balance
    }

    // Getter for balance
    public Double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
