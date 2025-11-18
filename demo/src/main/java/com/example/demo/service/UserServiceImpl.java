package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.security.CustomUserDetails;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public void addUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepo.save(user);
    }


    @Override
    public UserDetails loadUserByName(String name) throws UsernameNotFoundException {
        return (UserDetails) userRepo.findByEmail(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + name));
    }


    public void addUser(User user) {
        userRepo.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new CustomUserDetails(user); // ✅ pass the user to the constructor  
    }

    // public List<Book>myBooks(User user){
      
        
    // }




}