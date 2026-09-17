package com.pragma.person.domain.api;

import com.pragma.person.domain.model.PersonModel;

import java.util.List;

public interface IPersonServicePort {

    void savePerson(PersonModel personModel);

    List<PersonModel> getAllPeople();
}