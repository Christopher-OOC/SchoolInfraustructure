package com.chris.exceptioons;

public class PasswordNotCorrectException extends RuntimeException {

    public PasswordNotCorrectException(String message) {
        super(message);
    }
}
