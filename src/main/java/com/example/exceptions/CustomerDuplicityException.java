package com.example.exceptions;

public class CustomerDuplicityException extends RuntimeException {

    public CustomerDuplicityException() {
        super("Customer already registered");
    }

}
