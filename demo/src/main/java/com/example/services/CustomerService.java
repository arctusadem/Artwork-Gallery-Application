package com.example.services;

import com.example.accessingdatajpa.CustomerRepository;
import com.example.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CustomerService {

    @Autowired
    CustomerRepository repository;

//    @Transactional
//    public void insertWithEntityManager(CustomerModel customer) {
//        repository.entityManager.persist(customer);
//    }

    @PersistenceContext
    private EntityManager entityManager;

//    @Transactional
//    public void insertWithQuery(CustomerModel customer) {
//        entityManager.createNativeQuery("INSERT INTO person (id, first_name, last_name) VALUES (?,?,?)")
//                .setParameter(1, customer.getId())
//                .setParameter(2, customer.getFirstName())
//                .setParameter(3, customer.getLastName())
//                .executeUpdate();
//    }

    @Transactional
    public void insertCustomer(CustomerModel customer) {
        this.entityManager.persist(customer);
    }

}
