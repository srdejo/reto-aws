package com.pragma.person.infrastructure.out.jpa.adapter;

import com.pragma.person.domain.model.PersonModel;
import com.pragma.person.domain.spi.IPersonPersistencePort;
import com.pragma.person.infrastructure.exception.NoDataFoundException;
import com.pragma.person.infrastructure.out.jpa.entity.PersonEntity;
import com.pragma.person.infrastructure.out.jpa.mapper.IPersonEntityMapper;
import com.pragma.person.infrastructure.out.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonJpaAdapter implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper personEntityMapper;


    @Override
    public void savePerson(PersonModel personModel) {
        PersonEntity personEntity = personRepository.save(personEntityMapper.toEntity(personModel));
        personEntityMapper.toPersonModel(personEntity);
    }

    @Override
    public List<PersonModel> getAllPeople() {
        List<PersonEntity> entityList = personRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return personEntityMapper.toPersonModelList(entityList);
    }
}