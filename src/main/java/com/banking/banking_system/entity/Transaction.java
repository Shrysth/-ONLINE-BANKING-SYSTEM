package com.banking.banking_system.entity;

import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	
    public Transaction(String type, Double amount, Account account) {
		type=this.type;
		account=this.account;
		amount=this.amount;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type;  // "DEPOSIT" or "WITHDRAWAL"
    private Double amount;
    
    @ManyToOne
    private Account account;

    private LocalDateTime transactionDate = LocalDateTime.now();

    // Constructor, getters, setters, etc.
}
