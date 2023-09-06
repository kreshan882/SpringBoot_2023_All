package com.kre.tknjwtoauth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModelDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
}