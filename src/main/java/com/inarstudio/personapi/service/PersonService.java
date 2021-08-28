package com.inarstudio.personapi.service;

import com.inarstudio.personapi.dto.response.MessageResponseDTO;
import com.inarstudio.personapi.dto.request.PersonDTO;
import com.inarstudio.personapi.entity.Person;
import com.inarstudio.personapi.mapper.PersonMapper;
import com.inarstudio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeaple = personRepository.findAll();
        return (List<PersonDTO>) allPeaple
                .stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
