package com.banking.banking_system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.banking_system.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}
