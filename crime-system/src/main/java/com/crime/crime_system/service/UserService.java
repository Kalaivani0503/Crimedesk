package com.crime.crime_system.service;

import com.crime.crime_system.entity.User;
import com.crime.crime_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String email, String password, String role) {

        User user = userRepository.findByEmail(email);

        if (user == null) return null;

        if (user.getPassword() == null || !user.getPassword().equals(password)) {
            return null;
        }

        if (user.getRole() == null || !user.getRole().equalsIgnoreCase(role)) {
            return null;
        }

        return user;
    }
}