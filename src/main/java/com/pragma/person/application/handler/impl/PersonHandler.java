package com.pragma.person.application.handler.impl;

import com.pragma.person.application.dto.request.PersonRequestDto;
import com.pragma.person.application.dto.response.PersonResponseDto;
import com.pragma.person.application.handler.IPersonHandler;
import com.pragma.person.application.mapper.IPersonRequestMapper;
import com.pragma.person.application.mapper.IPersonResponseMapper;
import com.pragma.person.domain.api.IPersonServicePort;
import com.pragma.person.domain.model.PersonModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonHandler implements IPersonHandler {

    private final IPersonServicePort personServicePort;
    private final IPersonRequestMapper personRequestMapper;
    private final IPersonResponseMapper personResponseMapper;

    @Override
    public void savePerson(PersonRequestDto personRequestDto) {
        PersonModel personModel = personRequestMapper.toPerson(personRequestDto);
        personServicePort.savePerson(personModel);
    }

    @Override
    public List<PersonResponseDto> getAllPeople() {
        return personResponseMapper.toResponseList(personServicePort.getAllPeople());
    }
}