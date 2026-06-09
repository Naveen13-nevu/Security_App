package com.springsecurity.service;

import com.springsecurity.entity.User;
import com.springsecurity.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
