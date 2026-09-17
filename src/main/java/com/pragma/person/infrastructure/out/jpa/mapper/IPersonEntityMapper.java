package com.pragma.person.infrastructure.out.jpa.mapper;

import com.pragma.person.domain.model.PersonModel;
import com.pragma.person.infrastructure.out.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPersonEntityMapper {

    PersonEntity toEntity(PersonModel personModel);
    PersonModel toPersonModel(PersonEntity personEntity);
    List<PersonModel> toPersonModelList(List<PersonEntity> personEntityList);
}