package com.example.accessingdatajpa;

import java.util.List;

import com.example.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

    List<CustomerModel> findByFirstName(String firstName);

    List<CustomerModel> findByLastName(String lastName);

    CustomerModel findById(long id);
}