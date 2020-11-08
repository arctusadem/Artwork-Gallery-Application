package com.example.accessingdatajpa;

import java.util.List;
import java.util.UUID;

import com.example.model.CustomerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

    List<CustomerModel> findByFirstName(String firstName);

    List<CustomerModel> findByLastName(String lastName);

    @Query(value = "SELECT * FROM TB_CUSTOMER WHERE DOC_TYPE = :doctype AND DOC_NUMBER = :docnumber", nativeQuery = true)
    CustomerModel findByDocTypeAndDocNumber(@Param(value = "doctype") String docType, @Param(value = "docnumber") String docNumber);

    CustomerModel findById(UUID id);

    //void insertCustomer(CustomerModel customer);
}