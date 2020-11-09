package com.example.adapters.http.customer.post;

import com.example.core.domain.customer.Customer;
import com.example.core.usecases.RegisterNewCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class PostCustomerController {

    private final RegisterNewCustomer registerNewCustomer;

    public PostCustomerController(RegisterNewCustomer registerNewCustomer){
        this.registerNewCustomer = registerNewCustomer;
    }

    private static final Logger log = LoggerFactory.getLogger(PostCustomerController.class);

    @PostMapping("/register")
    public void registerCustomer (@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                                  @RequestParam(value = "doctype") String docType, @RequestParam(value = "docnumber") String docNumber) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDocType(docType);
        customer.setDocNumber(docNumber);

        registerNewCustomer.execute(customer);
        log.info("Customer has been registered: {}",customer);
    }
}
