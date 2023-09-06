package com.kre.tknjwtoauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {

	   private static final String[] WHITE_LIST_URLS = {
	            "/hello",
	            "/register",
	            "/verifyRegistration*",
	            "/resendVerifyToken*"
	    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        		http
////        		.cors()
////                .and()
////                .csrf()
////                .disable()
////                .authorizeHttpRequests(authz-> authz
//////                		.requestMatchers(WHITE_LIST_URLS).permitAll()
////                		.requestMatchers("/api/**").authenticated()
////                		)
////                .oauth2Login(oauth2login ->
////                        oauth2login.loginPage("/oauth2/authorization/api-client-oidc"))
////                .oauth2Client(Customizer.withDefaults());
//        		
//        		
////                .cors().disable()
////                .csrf().disable()
////                .authorizeHttpRequests(authz-> authz
////                		.requestMatchers(WHITE_LIST_URLS).permitAll()	
////                		.requestMatchers(new AntPathRequestMatcher("/h2K/**")).permitAll()
////                		.requestMatchers("/api/**").authenticated()
////                );
//        		
////                .oauth2Login(oauth2login ->
////                        oauth2login.loginPage("/oauth2/authorization/api-client-oidc")
////                 )
////                .oauth2Client(Customizer.withDefaults());
//    	http.csrf().disable();
//
//    	http.authorizeRequests().anyRequest().permitAll();
//        return http.build();
//    }
    
    
    
    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
    	http
		// ...
		.authorizeHttpRequests(authorize -> authorize                                  
            //.dispatcherTypeMatchers(FORWARD, ERROR).permitAll() 
			.requestMatchers("/static/**", "/signup", "/hello").permitAll()         
			.requestMatchers("/admin/**").hasRole("ADMIN")                             
			//.requestMatchers("/db/**").access(allOf(hasAuthority('db'), hasRole('ADMIN')))   
			.anyRequest().denyAll()                                                
		);

	return http.build();
    }
}
