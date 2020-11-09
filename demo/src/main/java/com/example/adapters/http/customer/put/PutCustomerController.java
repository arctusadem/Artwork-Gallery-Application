package com.example.adapters.http.customer.put;

import com.example.core.usecases.ExcludeCustomer;
import com.example.core.usecases.UpdateCustomerRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /*@PutMapping("/update")
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

    }*/

    /*@GetMapping("/delete")
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
    }*/


}
