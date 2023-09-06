package com.kre.tknjwtoauth.service;

import com.kre.tknjwtoauth.entity.User;
import com.kre.tknjwtoauth.entity.VerificationToken;
import com.kre.tknjwtoauth.model.UserModelDTO;

public interface UserService {
	User registerUser(UserModelDTO userModelDTO);
	
	
	void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);
}
