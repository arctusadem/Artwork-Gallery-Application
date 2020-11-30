package com.example.exceptions;

import javax.validation.ConstraintViolationException;

public class MissingInformationException extends RuntimeException {

    MissingInformationException(){
        super("Information missing");
    }

}
