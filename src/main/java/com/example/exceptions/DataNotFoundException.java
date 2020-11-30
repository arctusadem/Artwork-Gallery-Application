package com.example.exceptions;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
        super("Data not found");
    }

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
