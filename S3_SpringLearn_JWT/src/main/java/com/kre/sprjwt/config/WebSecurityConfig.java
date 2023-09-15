package com.kre.sprjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kre.sprjwt.jwtutility.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   
	@Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    
	@Autowired
    private UserDetailsService sprSeqUserDetSer;  //get data from spring Sqe [UserDetailsService]
    
	@Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(sprSeqUserDetSer).passwordEncoder(passwordEncoder()); // with encoded password
        auth.userDetailsService(sprSeqUserDetSer); // without encode
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();  // with encoded password
        return NoOpPasswordEncoder.getInstance();  //with out encode
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSeq) throws Exception {

    	   //Cross-Site Request Forgery attacks
    	   // white list page
    	   // all other requests need to be authenticated
        	httpSeq.csrf().disable()
                   .authorizeRequests().antMatchers("/authenticate","/wlist").permitAll()  
                   .anyRequest().authenticated().and()
                   .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                   .sessionManagement()
                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS);        // Add a filter to validate the tokens with every request
        
        	httpSeq.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
