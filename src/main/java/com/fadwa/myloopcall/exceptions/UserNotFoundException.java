package com.fadwa.myloopcall.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User Not Found with provided attribute");
    }
}
