package com.example.adapters.http.customer.post;

import com.example.adapters.http.customer.post.dto.PostCustomerConverter;
import com.example.adapters.http.customer.post.dto.RequestPostCustomer;
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
    public void registerCustomer (@RequestBody @Validated RequestPostCustomer body) {

        Customer customer = PostCustomerConverter.toDomain(body);

        registerNewCustomer.execute(customer);
        log.info("Customer has been registered: {}",customer);
    }
}
