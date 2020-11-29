package com.example.adapters.http.customer.post;

import com.example.core.domain.customer.Customer;
import com.example.core.usecases.RegisterNewCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("customer")
public class PostCustomerController {

    private final RegisterNewCustomer registerNewCustomer;

    public PostCustomerController(RegisterNewCustomer registerNewCustomer){
        this.registerNewCustomer = registerNewCustomer;
    }

    private static final Logger log = LoggerFactory.getLogger(PostCustomerController.class);

    @PostMapping(value = "/register", consumes = "application/json")
    public void registerCustomer (@RequestBody @Validated Map<String,String> body) {

        Customer customer = new Customer();
        customer.setFirstName(body.get("firstname"));
        customer.setLastName(body.get("lastname"));
        customer.setDocType(body.get("doctype"));
        customer.setDocNumber(body.get("docnumber"));

        registerNewCustomer.execute(customer);
        log.info("Customer has been registered: {}",customer);
    }
}
