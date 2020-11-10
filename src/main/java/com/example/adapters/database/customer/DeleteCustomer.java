package com.example.adapters.database.customer;

import com.example.core.domain.customer.Customer;
import com.example.core.domain.customer.DeleteCustomerPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeleteCustomer implements DeleteCustomerPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomer(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    @Override
    public void deleteCustomer(Customer customer) {

        CustomerModel customerToDelete = null;

        if (customer.getIdCustomer() != null)
            customerToDelete = customerRepository.findByIdCustomer(customer.getIdCustomer().toString());

        customerRepository.delete(customerToDelete);
    }
}
