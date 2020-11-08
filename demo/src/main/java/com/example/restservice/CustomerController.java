package com.example.restservice;

import com.example.accessingdatajpa.CustomerRepository;
import com.example.model.CustomerModel;
import com.example.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerService customerUseCase;

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/register")
    public void registerCustomer (@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                                  @RequestParam(value = "doctype") String docType, @RequestParam(value = "docnumber") String docNumber) {

        CustomerModel customer = new CustomerModel(firstName, lastName, docType, docNumber);

        repository.save(customer);

        //customerUseCase.insertCustomer(customer);

    }


}
