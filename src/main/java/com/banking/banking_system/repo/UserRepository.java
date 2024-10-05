package com.banking.banking_system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.banking_system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

	Optional<User> findByUsernameOptional(String username);
}

