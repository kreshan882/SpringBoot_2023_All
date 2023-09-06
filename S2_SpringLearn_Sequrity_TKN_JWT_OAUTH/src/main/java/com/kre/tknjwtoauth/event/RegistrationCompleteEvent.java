package com.kre.tknjwtoauth.event;

import org.springframework.context.ApplicationEvent;

import com.kre.tknjwtoauth.entity.User;

import lombok.Data;


//this event create for: create tocken & send email when register
@Data
public class RegistrationCompleteEvent extends ApplicationEvent  { 

    private final User user;
    private final String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
