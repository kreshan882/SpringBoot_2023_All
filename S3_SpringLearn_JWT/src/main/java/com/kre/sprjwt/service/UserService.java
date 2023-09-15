package com.kre.sprjwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//fetching user details from the database using the username.
//The Spring Security Authentication Manager calls this method for getting the user details from the database
//Here we are getting the user details from a hardcoded User List.

//kreshan password //load user:kreshan data to Spring[UserDetailsService]
@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("kreshan".equals(username)) {
            //return new User("kreshan", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
        
            return new User("kreshan", "password2", new ArrayList<>());  //sprinf Seq User object
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}