package com.banking.banking_system.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.banking_system.entity.User;
import com.banking.banking_system.repo.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String password , String fullname, String Address, String branchName  ) {
        User user = new User(username, password,fullname,Address,branchName);
        return userRepository.save(user);
    }

    public Optional<User>findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	public Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

    public User findByusername(String username) {
        return userRepository.findByusername(username);
    }

}


