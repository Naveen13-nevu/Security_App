package com.springsecurity.service;

import com.springsecurity.entity.User;
import com.springsecurity.entity.UserPrinciple;
import com.springsecurity.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    private MyUserDetailsService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username);
        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");

        }
        return new UserPrinciple(user);
    }
}
