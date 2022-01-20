package com.group8.Leaderboardbackend.exception;

public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException(String msg) {
        super((msg));
    }
}
