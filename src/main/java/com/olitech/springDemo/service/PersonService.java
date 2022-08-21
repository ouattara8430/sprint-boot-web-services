package com.olitech.springDemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.olitech.springDemo.dao.PersonDao;
import com.olitech.springDemo.model.Person;

@Service
public class PersonService {
    
    private final PersonDao personDao;

    // constructor
    @Autowired
    public PersonService(@Qualifier("pdao") PersonDao personDao){
        this.personDao = personDao;
    }

    // add person
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    // select
    public List<Person> getAllPersons(){
        return personDao.getAllPersons();
    }

    // select by id
    public Optional<Person> getPersonById(UUID id){
        return personDao.getPersonById(id);
    }

}
