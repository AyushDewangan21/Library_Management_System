package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    void addUser(String name, String email, String password);

    UserDetails loadUserByName(String email) throws UsernameNotFoundException;
}
