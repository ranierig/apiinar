package com.inarstudio.personapi.mapper;


import com.inarstudio.personapi.dto.request.PersonDTO;
import com.inarstudio.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    public static PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    public abstract Person toModel(PersonDTO personDTO);

    public abstract PersonDTO toDTO(Person person) ;

}
