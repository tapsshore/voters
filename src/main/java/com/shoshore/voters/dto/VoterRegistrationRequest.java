package com.shoshore.voters.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoterRegistrationRequest {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;
    private String password;
    private String repeatPassword;
    private Date dateOfBirth;
}
