package com.banking.banking_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.banking_system.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

