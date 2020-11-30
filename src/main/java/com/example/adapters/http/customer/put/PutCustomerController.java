package com.example.adapters.http.customer.put;

import com.example.adapters.http.customer.post.dto.RequestPostCustomer;
import com.example.adapters.http.customer.put.dto.PutCustomerConverter;
import com.example.adapters.http.customer.put.dto.RequestPutCustomer;
import com.example.core.domain.customer.Customer;
import com.example.core.usecases.ExcludeCustomer;
import com.example.core.usecases.UpdateCustomerRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class PutCustomerController {

    private final UpdateCustomerRegistration updateCustomerRegistration;


    public PutCustomerController(UpdateCustomerRegistration updateCustomerRegistration){
        this.updateCustomerRegistration = updateCustomerRegistration;
    }

    private static final Logger log = LoggerFactory.getLogger(PutCustomerController.class);

    @PutMapping("/update")
    public void updateCustomer (@RequestBody RequestPutCustomer body) {

        Customer customer = PutCustomerConverter.toDomain(body);

        updateCustomerRegistration.execute(customer);

    }
}
