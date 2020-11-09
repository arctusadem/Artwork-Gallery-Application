package com.example.adapters.database.customer;

import com.example.core.domain.customer.Customer;

public class CustomerConverter {


    public static CustomerModel toModel(Customer customer){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setDocNumber(customer.getDocNumber());
        customerModel.setDocType(customer.getDocType());

        return customerModel;
    }



}
