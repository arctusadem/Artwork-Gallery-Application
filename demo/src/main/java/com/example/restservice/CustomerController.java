package com.example.restservice;

import com.example.accessingdatajpa.CustomerRepository;
import com.example.model.CustomerModel;
import com.example.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerService customerUseCase;

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/search")
    public ResponseEntity<List<CustomerModel>> getCustomer(@RequestParam Map<String,String> customer) {

        List<CustomerModel> listCustomers = new ArrayList<>();

        if (customer.containsKey("firstname"))
            listCustomers = repository.findByFirstName(Optional.of(customer.get("firstname")));
        else if (customer.containsKey("lastname"))
            listCustomers = repository.findByLastName(Optional.of(customer.get("lastname")));
        else if (customer.containsKey("doctype") && customer.containsKey("docnumber"))
            listCustomers = repository.findByDocTypeAndDocNumber(Optional.of(customer.get("doctype")), Optional.of(customer.get("docnumber")));


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

    @GetMapping("/register")
    public void registerCustomer (@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                                  @RequestParam(value = "doctype") String docType, @RequestParam(value = "docnumber") String docNumber) {

        CustomerModel customer = new CustomerModel(firstName, lastName, docType, docNumber);

        repository.save(customer);

    }

    @GetMapping("/update")
    public void updateCustomer (@RequestParam(value = "id") UUID id,
                                @RequestParam(value = "firstname") Optional<String> firstName,
                                @RequestParam(value = "lastname") Optional<String> lastName,
                                @RequestParam(value = "doctype") Optional<String> docType,
                                @RequestParam(value = "docnumber") Optional<String> docNumber) {

        CustomerModel customer = repository.findById(id);

        if(firstName.isPresent())
            customer.setFirstName(firstName.get());
        if(lastName.isPresent())
            customer.setLastName(lastName.get());
        if(docType.isPresent())
            customer.setDocType(docType.get());
        if(docNumber.isPresent())
            customer.setDocNumber(docNumber.get());

        repository.save(customer);

    }

    @GetMapping("/delete")
    public void deleteCustomer (@RequestParam(value = "firstname") Optional<String> firstName, @RequestParam(value = "lastname") Optional<String> lastName,
                                @RequestParam(value = "doctype") Optional<String> docType, @RequestParam(value = "docnumber") Optional<String> docNumber) {

        List<CustomerModel> customer = null;

        if(firstName.isPresent())
            customer = repository.findByFirstName(firstName);
        else if(lastName.isPresent())
            customer = repository.findByLastName(lastName);
        else if(docType.isPresent() && docNumber.isPresent())
            customer = repository.findByDocTypeAndDocNumber(docType, docNumber);

        repository.deleteAll(customer);
    }


}
