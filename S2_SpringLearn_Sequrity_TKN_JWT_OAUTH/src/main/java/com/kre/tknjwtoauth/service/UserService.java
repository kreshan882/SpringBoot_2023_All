package com.kre.tknjwtoauth.service;

import com.kre.tknjwtoauth.entity.Userk;
import com.kre.tknjwtoauth.entity.VerificationToken;
import com.kre.tknjwtoauth.model.UserModel;

import java.util.Optional;

public interface UserService {
    Userk registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, Userk user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    Userk findUserByEmail(String email);

    void createPasswordResetTokenForUser(Userk user, String token);

    String validatePasswordResetToken(String token);

    Optional<Userk> getUserByPasswordResetToken(String token);

    void changePassword(Userk user, String newPassword);

    boolean checkIfValidOldPassword(Userk user, String oldPassword);
}
