package com.pragma.person.infrastructure.out.jpa.repository;

import com.pragma.person.infrastructure.out.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {

}