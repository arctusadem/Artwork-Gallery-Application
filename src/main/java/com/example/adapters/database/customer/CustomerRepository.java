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
public interface CustomerRepository extends CrudRepository<CustomerModel, String> {

    List<CustomerModel> findByFirstName(String firstName);

    List<CustomerModel> findByLastName(String lastName);

    @Query(value = "SELECT * FROM TB_CUSTOMER WHERE DOC_TYPE = :doctype AND DOC_NUMBER = :docnumber", nativeQuery = true)
    List<CustomerModel> findByDocTypeAndDocNumber(@Param(value = "doctype") String docType, @Param(value = "docnumber") String docNumber);

    @Query(value = "SELECT * FROM TB_CUSTOMER WHERE id_customer = :idCustomer", nativeQuery = true)
    CustomerModel findByIdCustomer(@Param(value = "idCustomer")String idCustomer);
}