package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.model.CustomerModel;
import com.example.accessingdatajpa.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<CustomerModel>> getCustomer(@RequestParam Map<String,String> customer) {

        List<CustomerModel> listCustomers = new ArrayList<>();

        if (customer.containsKey("firstname"))
            listCustomers = repository.findByFirstName(customer.get("firstname"));
        else if (customer.containsKey("lastname"))
            listCustomers = repository.findByLastName(customer.get("lastname"));

        log.info("-----------------------");
        log.info("Dados informados: " + customer.get("firstname") + " " + customer.get("lastname"));
        log.info("-----------------------");


        log.info("Nomes da lista retornada:");
        for (CustomerModel lc : listCustomers) {
            log.info(lc.getFirstName() + " " + lc.getLastName());
        }

        log.info("-----------------------");

        Iterable<CustomerModel> customers = repository.findAll();

        for (CustomerModel c : customers) {
            log.info("Cliente " + c.getId() + ": " + c.getFirstName() + " " + c.getLastName());
        }

        return ResponseEntity.ok(listCustomers);

    }
}