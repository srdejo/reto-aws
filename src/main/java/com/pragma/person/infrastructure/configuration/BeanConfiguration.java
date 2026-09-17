package com.pragma.person.infrastructure.configuration;

import com.pragma.person.domain.api.IPersonServicePort;
import com.pragma.person.domain.spi.IPersonPersistencePort;
import com.pragma.person.domain.usecase.PersonUseCase;
import com.pragma.person.infrastructure.out.jpa.adapter.PersonJpaAdapter;
import com.pragma.person.infrastructure.out.jpa.mapper.IPersonEntityMapper;
import com.pragma.person.infrastructure.out.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IPersonRepository personRepository;
    private final IPersonEntityMapper personEntityMapper;

    @Bean
    public IPersonPersistencePort personPersistencePort() {
        return new PersonJpaAdapter(personRepository, personEntityMapper);
    }

    @Bean
    public IPersonServicePort personServicePort() {
        return new PersonUseCase(personPersistencePort());
    }
}