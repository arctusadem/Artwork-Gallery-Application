package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String docType;
    private String docNumber;

    protected CustomerModel() {}

    public CustomerModel(Long id, String firstName, String lastName, String docType, String docNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.docNumber = docNumber;
    }

    public CustomerModel(String firstName, String lastName, String docType, String docNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.docNumber = docNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', docType='%s', docNumber='%s']",
                id, firstName, lastName, docType, docNumber);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocType() {
        return docType;
    }

    public String getDocNumber() {
        return docNumber;
    }
}