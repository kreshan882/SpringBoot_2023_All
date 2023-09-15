package com.kre.sprjwt.config;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * This class will extend Spring’s AuthenticationEntryPoint class and override its method commence.
 * It rejects every unauthenticated request and send error code 401
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,AuthenticationException authException) throws IOException {
        
    		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized_kk");
    	
    }
}
