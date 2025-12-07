package com.fadwa.myloopcall.exceptions;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException() {
        super("No account found for the provided email");
    }
}
