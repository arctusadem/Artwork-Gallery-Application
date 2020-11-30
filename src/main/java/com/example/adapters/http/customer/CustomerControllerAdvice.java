package com.example.adapters.http.customer;

import com.example.exceptions.DataNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CustomerControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }

        ErrorResponse errorResponse =
                new ErrorResponse(BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> CustomerNotFoundExceptionHandler (DataNotFoundException ex, WebRequest request){

        List<String> errors = new ArrayList<String>();

        ErrorResponse errorResponse =
                new ErrorResponse(BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}
