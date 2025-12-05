package com.bygolf.to_do_list_spring.service;

import com.bygolf.to_do_list_spring.model.Person;
import com.bygolf.to_do_list_spring.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons() {
        logger.debug("Receiving all persons");
        return personRepository.findAll();
    }

}
