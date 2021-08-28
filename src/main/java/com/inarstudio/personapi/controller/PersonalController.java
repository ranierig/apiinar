package com.inarstudio.personapi.controller;

import com.inarstudio.personapi.dto.response.MessageResponseDTO;
import com.inarstudio.personapi.dto.request.PersonDTO;
import com.inarstudio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")

public class PersonalController {

    private PersonService personService;

    @Autowired
    public PersonalController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    public List<PersonDTO> listAll() {
        return personService.listAll();
    }
}
