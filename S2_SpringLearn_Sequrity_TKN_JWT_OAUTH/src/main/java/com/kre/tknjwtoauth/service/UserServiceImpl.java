package com.kre.tknjwtoauth.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kre.tknjwtoauth.entity.User;
import com.kre.tknjwtoauth.entity.VerificationToken;
import com.kre.tknjwtoauth.model.UserModelDTO;
import com.kre.tknjwtoauth.repository.UserRepository;
import com.kre.tknjwtoauth.repository.VerificationTokenRepository;

public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;  // spring sequrity object
	
	 @Autowired
	 private VerificationTokenRepository verificationTokenRepository;
	
    public User registerUser(UserModelDTO userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }
    
 
    // save varification token to the table
    public void saveVerificationTokenForUser(String token, User user) {
    	
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
        
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken
                = verificationTokenRepository.findByToken(token);

        if (verificationToken == null) {
            return "invalid";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if ((verificationToken.getExpirationTime().getTime()
                - cal.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        }

        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken
                = verificationTokenRepository.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }
//
//    @Override
//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
}
