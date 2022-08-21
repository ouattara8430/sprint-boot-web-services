package com.olitech.springDemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import com.olitech.springDemo.model.Person;

@Repository("pdao")
public class PersonDataAccess implements PersonDao {

    // create a virual database
    List<Person> DB = new ArrayList<>();

    @Override
    public List<Person> getAllPersons() {
        return DB;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
    
    @Override
    public int updatePeron(UUID id, Person person) {
        return getPersonById(id).map(
            update -> {
                int indexOfPersonToDelete = DB.indexOf(update);
                if(indexOfPersonToDelete >= 0){
                    DB.set(indexOfPersonToDelete, new Person(id, person.getName()));
                    return 1;
                }
                return 0;
            }
        ).orElse(0);
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> person = getPersonById(id);
        if(person.isEmpty()){
            return 0;
        }
        DB.remove(person.get());
        return 1;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
    
    

}
