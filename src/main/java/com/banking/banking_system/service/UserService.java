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

    public User registerUser(String username, String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//	public static Object findById(Long userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}


