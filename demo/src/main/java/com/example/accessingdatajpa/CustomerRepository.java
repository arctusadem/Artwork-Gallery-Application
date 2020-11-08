package com.example.accessingdatajpa;

import java.util.List;

import com.example.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    List<CustomerModel> findByFirstName(String firstName);

    List<CustomerModel> findByLastName(String lastName);

    List<CustomerModel> findByDocTypeAndDocNumber(String docType, String docNumber);

    CustomerModel findById(long id);

    //void insertCustomer(CustomerModel customer);
}