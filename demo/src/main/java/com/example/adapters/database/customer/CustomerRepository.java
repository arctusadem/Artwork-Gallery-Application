package com.example.adapters.database.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.adapters.database.customer.CustomerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

    List<CustomerModel> findByFirstName(Optional<String> firstName);

    List<CustomerModel> findByLastName(Optional<String> lastName);

    @Query(value = "SELECT * FROM TB_CUSTOMER WHERE DOC_TYPE = :doctype AND DOC_NUMBER = :docnumber", nativeQuery = true)
    List<CustomerModel> findByDocTypeAndDocNumber(@Param(value = "doctype") Optional<String> docType, @Param(value = "docnumber") Optional<String> docNumber);

    CustomerModel findById(UUID id);
}