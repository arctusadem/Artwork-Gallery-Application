package com.example.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel {

    @Id
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String docType;
    private String docNumber;

    protected CustomerModel() {}

    public CustomerModel(String firstName, String lastName, String docType, String docNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.docNumber = docNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[uuid=%s, firstName='%s', lastName='%s', docType='%s', docNumber='%s']",
                id, firstName, lastName, docType, docNumber);
    }

    public UUID getId() {
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