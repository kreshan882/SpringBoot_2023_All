package com.dailycodebuffer.jwt.filter;

import com.dailycodebuffer.jwt.service.UserService;
import com.dailycodebuffer.jwt.utility.JWTUtility;

//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// intersepeter (when all request come ) validate token
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserService userService;

    //Postman Authorization request checking , validate token each request
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;

        if(null != authorization && authorization.startsWith("Bearer ")) {
            token = authorization.substring(7); // remove ["Bearer "]
            userName = jwtUtility.getUsernameFromToken(token);
        }

        
        
        if(null != userName && SecurityContextHolder.getContext().getAuthentication() == null) {
            
        	UserDetails userDetails = userService.loadUserByUsername(userName);

        	//token validation 
            if(jwtUtility.validateToken(token,userDetails)) {
            	
                UsernamePasswordAuthenticationToken UnPwAuthToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                UnPwAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(UnPwAuthToken);
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
