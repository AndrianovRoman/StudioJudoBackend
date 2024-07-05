package com.example.studioJudo.exception;

public class NoAuthorityException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Недостаточно прав";

    public NoAuthorityException() {
        super(DEFAULT_MESSAGE);
    }

}
