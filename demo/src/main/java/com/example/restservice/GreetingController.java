package com.example.restservice;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.DemoApplication;
import com.example.accessingdatajpa.Customer;
import com.example.accessingdatajpa.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private CustomerRepository repository;

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/rep")
    public List<Customer> getCustomer(@RequestParam(value = "last-name") String lastName) {

        List<Customer> custom = repository.findByLastName(lastName);
        Iterable<Customer> customers = repository.findAll();

        log.info("-----------------------");
        log.info("O costumer do ID: ", lastName);
        log.info("-----------------------");
        log.info("É o:", custom.toString());
        log.info("-----------------------");

        for (Customer c : custom) {
            log.info("É o Braia: ",c.getFirstName().toString());
        }

        for (Customer c : customers) {
            log.info("É o Tourette: ", c.toString());
        }

        return custom;

    }
}