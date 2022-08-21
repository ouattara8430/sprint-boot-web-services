package com.olitech.springDemo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.olitech.springDemo.model.Person;

public interface PersonDao {
    
    int insertPerson(UUID id, Person person);

    // insert
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // get records
    List<Person> getAllPersons();

    // select by id
    Optional<Person> getPersonById(UUID id);

    // update
    int updatePeron(UUID id, Person person);

    // delete
    int deletePerson(UUID id);

}
