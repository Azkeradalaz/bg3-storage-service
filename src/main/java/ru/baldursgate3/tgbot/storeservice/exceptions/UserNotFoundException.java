package ru.baldursgate3.tgbot.storeservice.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
