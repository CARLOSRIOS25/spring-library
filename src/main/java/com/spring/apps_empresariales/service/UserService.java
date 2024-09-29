package com.spring.apps_empresariales.service;

import com.spring.apps_empresariales.model.User;
import com.spring.apps_empresariales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User buscarUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
