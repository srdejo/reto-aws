package com.pragma.person.domain.model;

import com.pragma.person.domain.exception.InvalidPersonException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonModel {
    private Long id;
    private String identificationNumber;
    private String name;
    private String email;

    public PersonModel(Long id, String identificationNumber, String name, String email) {
        if (identificationNumber == null || identificationNumber.isBlank()) {
            throw new InvalidPersonException("Identification number is required");
        }
        if (name == null || name.isBlank()) {
            throw new InvalidPersonException("Name is required");
        }
        if (email == null || email.isBlank()) {
            throw new InvalidPersonException("Email is required");
        }
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.email = email;
    }
}
