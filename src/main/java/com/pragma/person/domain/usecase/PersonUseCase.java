package com.pragma.person.domain.usecase;

import com.pragma.person.domain.api.IPersonServicePort;
import com.pragma.person.domain.model.PersonModel;
import com.pragma.person.domain.spi.IPersonPersistencePort;

import java.util.List;

public class PersonUseCase implements IPersonServicePort {

    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public void savePerson(PersonModel personModel) {
        personPersistencePort.savePerson(personModel);
    }

    @Override
    public List<PersonModel> getAllPeople() {
        return personPersistencePort.getAllPeople();
    }
}