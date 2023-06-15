package com.QuiZZila.Tubes.main.service;

import com.QuiZZila.Tubes.main.model.Users;
import com.QuiZZila.Tubes.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Users findUserByEmail(String email) {
        try {
            Users userToFind = userRepository.findByEmail(email);
            return userToFind;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
