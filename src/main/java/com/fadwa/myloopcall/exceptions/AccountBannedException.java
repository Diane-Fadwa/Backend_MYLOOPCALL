package com.fadwa.myloopcall.exceptions;

public class AccountBannedException extends RuntimeException {
    public AccountBannedException() {
        super("This account has been banned. Please contact the administrator for further assistance.");
    }
}
