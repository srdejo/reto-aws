package com.pragma.person.application.handler;

import com.pragma.person.application.dto.request.PersonRequestDto;
import com.pragma.person.application.dto.response.PersonResponseDto;

import java.util.List;

public interface IPersonHandler {

    void savePerson(PersonRequestDto personRequestDto);

    List<PersonResponseDto> getAllPeople();
}