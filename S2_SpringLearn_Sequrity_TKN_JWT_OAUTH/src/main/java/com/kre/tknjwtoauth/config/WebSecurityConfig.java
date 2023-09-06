package com.kre.tknjwtoauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //this will load spring seq to the system
public class WebSecurityConfig {

	
    @Bean 
    public PasswordEncoder passwordEncoder() {
    	
    	// password encoder Length define hear to spring, then i can use UserServiceImpl
        return new BCryptPasswordEncoder(11);   
    }
    
}
