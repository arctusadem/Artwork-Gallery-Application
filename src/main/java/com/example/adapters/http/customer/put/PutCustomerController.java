package com.example.adapters.http.customer.put;

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
    private final ExcludeCustomer excludeCustomer;

    public PutCustomerController(UpdateCustomerRegistration updateCustomerRegistration,
                                 ExcludeCustomer excludeCustomer){
        this.updateCustomerRegistration = updateCustomerRegistration;
        this.excludeCustomer=excludeCustomer;
    }

    private static final Logger log = LoggerFactory.getLogger(PutCustomerController.class);

    @PutMapping("/update")
    public void updateCustomer (@RequestParam(value = "id") UUID id,
                                @RequestParam(value = "firstname", required = false) String firstName,
                                @RequestParam(value = "lastname", required = false) String lastName,
                                @RequestParam(value = "doctype", required = false) String docType,
                                @RequestParam(value = "docnumber", required = false) String docNumber) {

        Customer customer = new Customer();

        customer.setIdCustomer(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDocType(docType);
        customer.setDocNumber(docNumber);

        updateCustomerRegistration.execute(customer);

    }

    @PutMapping("/delete")
    public void deleteCustomer (@RequestParam(value = "id", required = false) UUID id) {
        
        Customer customer = new Customer();

        customer.setIdCustomer(id);

        excludeCustomer.execute(customer);

    }


}
