package com.kre.tknjwtoauth.event;

import com.kre.tknjwtoauth.entity.Userk;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private final Userk user;
    private final String applicationUrl;

    public RegistrationCompleteEvent(Userk user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
