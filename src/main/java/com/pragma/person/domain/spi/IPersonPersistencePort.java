package com.pragma.person.domain.spi;

import com.pragma.person.domain.model.PersonModel;
import java.util.List;

public interface IPersonPersistencePort {
    void savePerson(PersonModel personModel);

    List<PersonModel> getAllPeople();
}