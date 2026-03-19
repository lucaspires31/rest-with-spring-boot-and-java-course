package br.com.lucaspires31.mapper.custom;

import br.com.lucaspires31.data.dto.v2.PersonDTOv2;
import br.com.lucaspires31.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person){
        PersonDTOv2 dto = new PersonDTOv2() ;
        dto.setId(person.getId());
        dto.setFirstname(person.getFirstname());
        dto.setLastname(person.getLastname());
        dto.setBirthday(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOv2 person){
        Person entity = new Person() ;
        entity.setId(person.getId());
        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        //entity.setBirthday(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
