package org.example.exception;

public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}