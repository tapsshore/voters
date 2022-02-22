package com.shoshore.voters.exceptions;
import org.springframework.security.core.AuthenticationException;

public class VoterAlreadyRegisteredException extends AuthenticationException {
    public VoterAlreadyRegisteredException(String message) {
        super(message);
    }
}
