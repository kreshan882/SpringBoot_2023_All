package com.dailycodebuffer.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

////UserDetailsService | UserDetails | User  -- from spring security
@Service
public class UserService implements UserDetailsService { 

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //By pass: need to get USER details form the Database
    	
    	// add details to spring sequrity user module	
        return new User("admin","password",new ArrayList<>()); // un| pw| role_list
    }
}
