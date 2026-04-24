package br.com.lucaspires31.services;

import br.com.lucaspires31.data.dto.v1.PersonDTO;
import br.com.lucaspires31.data.dto.v2.PersonDTOv2;
import br.com.lucaspires31.exception.ResourceNotFoundException;

import br.com.lucaspires31.mapper.custom.PersonMapper;
import br.com.lucaspires31.model.Person;
import br.com.lucaspires31.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.lucaspires31.mapper.ObjectMapper.parseListObject;
import static br.com.lucaspires31.mapper.ObjectMapper.parseObject;


@Service

public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;


    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");

        return parseListObject( repository.findAll(), PersonDTO.class);

    }


    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return parseObject(entity, PersonDTO.class);
    }


    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person!");
        var entity= parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);

    }

    public PersonDTOv2 createV2 (PersonDTOv2 person) {
        logger.info("Creating one Person V2!");
        var entity= converter.convertDTOToEntity(person);

        return converter.convertEntityToDTO(repository.save(entity));

    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));


        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);


    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);


    }
}

