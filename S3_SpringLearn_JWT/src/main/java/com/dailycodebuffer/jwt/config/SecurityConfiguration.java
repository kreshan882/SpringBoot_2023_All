package com.dailycodebuffer.jwt.config;

import com.dailycodebuffer.jwt.filter.JwtFilter;
import com.dailycodebuffer.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService; //extern with UserDetailsService (spring seq) 

    
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);  // call to DB and validate (by pass this) 
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http.csrf()
//        .disable()
//        .authorizeRequests()
//        .antMatchers("/authenticate")
//        .permitAll()
//        .anyRequest()
//        .authenticated();
    	
    	http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate")  // whitelist url
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()   // inform to dont use OLD state full session manager
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
    	
    	// token Authondication filter (all requesr atthindicate with token filter
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); 

    }
}
