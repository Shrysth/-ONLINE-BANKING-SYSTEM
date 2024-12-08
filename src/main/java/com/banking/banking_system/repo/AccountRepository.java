package com.banking.banking_system.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.banking_system.entity.Account;
import com.banking.banking_system.entity.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account>findByUser(User user);
}

