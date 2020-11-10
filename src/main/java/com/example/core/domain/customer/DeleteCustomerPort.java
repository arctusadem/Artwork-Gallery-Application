package com.example.core.domain.customer;

import com.example.adapters.database.customer.CustomerModel;

public interface DeleteCustomerPort {

    void deleteCustomer(Customer customer);

}
