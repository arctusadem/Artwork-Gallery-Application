package com.example.adapters.http.customer.put;

import com.example.adapters.http.customer.put.dto.PutCustomerConverter;
import com.example.adapters.http.customer.put.dto.RequestPutCustomer;
import com.example.core.domain.customer.Customer;
import com.example.core.usecases.UpdateCustomerRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class PutCustomerController {

    private final UpdateCustomerRegistration updateCustomerRegistration;
    private final RequestPutValidator requestPutValidator;


    public PutCustomerController(UpdateCustomerRegistration updateCustomerRegistration, RequestPutValidator requestPutValidator) {
        this.updateCustomerRegistration = updateCustomerRegistration;
        this.requestPutValidator = requestPutValidator;
    }

    private static final Logger log = LoggerFactory.getLogger(PutCustomerController.class);

    @PutMapping("/update")
    public ResponseEntity<Object> updateCustomer (@RequestBody RequestPutCustomer body) {

        requestPutValidator.valid(body);

        Customer customer = PutCustomerConverter.toDomain(body);

        updateCustomerRegistration.execute(customer);

        return ResponseEntity.ok("Registro atualizado com sucesso!");
    }
}
