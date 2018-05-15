package com.div.spring.service;

import com.div.spring.dao.User;
import com.div.spring.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Div on 2018-05-08.
 */

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthority("ROLE_USER");
        user.setEnabled(true);

        return userRepository.save(user);
    }

    public boolean exists(String username) {
        if(userRepository.findByUsername(username) != null)
            return true;
        return false;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
