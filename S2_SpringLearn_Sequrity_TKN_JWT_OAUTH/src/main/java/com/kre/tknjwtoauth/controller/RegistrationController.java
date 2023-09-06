package com.kre.tknjwtoauth.controller;

import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kre.tknjwtoauth.entity.User;
import com.kre.tknjwtoauth.event.RegistrationCompleteEvent;
import com.kre.tknjwtoauth.model.UserModelDTO;
import com.kre.tknjwtoauth.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {

	  @Autowired
	  private UserService userService;
	  
	  @Autowired
	  private ApplicationEventPublisher publisher; // publish to spring event publisher
	  
	  
	  	@PostMapping("/register")
	    public String registerUser(@RequestBody UserModelDTO userModelDTO, final HttpServletRequest request) {
	        User user = userService.registerUser(userModelDTO);
	        
	        //when publish event different aggregrator()RegistrationCompleteEventListener)  
	        //then do the tocken creation + email send
	        publisher.publishEvent(new RegistrationCompleteEvent(
	                user,
	                "url"
	               // applicationUrl(request)
	        ));
	        return "User Registration Success....";
	    }
}
