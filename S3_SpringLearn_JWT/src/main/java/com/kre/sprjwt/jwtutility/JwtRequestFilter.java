package com.kre.sprjwt.jwtutility;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kre.sprjwt.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter class.
 * For any incoming request this Filter class gets executed. It checks if the request has a
 * valid JWT token. If it has a valid JWT Token then it sets the Authentication in the context,
 * to specify that the current user is authenticated.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
	@Autowired
    private UserService userService;
    
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        
    	final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
       
	        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {  // remove Bearer token
	            
	        		jwtToken = requestTokenHeader.substring(7);
		            try {
		                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		            } 
		            catch (IllegalArgumentException e) {
		                System.out.println("Unable to get JWT Token");
		            } 
		            catch (ExpiredJwtException e) {
		                System.out.println("JWT Token has expired");
		            }
	        } else {
	            logger.warn("JWT Token does not begin with Bearer String");
	        }        
	        
	        
	        // Once we get the token validate it.
	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = this.userService.loadUserByUsername(username);  // get user full details with USER_ROLE, from DB

		            // authentication
		            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {  // token expire time & user validation doing
		                
		            		UsernamePasswordAuthenticationToken umPwAuthenticationTkn = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		            		umPwAuthenticationTkn.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		            		
			                // user is authenticated. So it passes the
			                // Spring Security Configurations successfully.
			                SecurityContextHolder.getContext().setAuthentication(umPwAuthenticationTkn);
		            }
	        }
	        
	        
        chain.doFilter(request, response);
    }
    
    
}
