package com.olitech.springDemo.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olitech.springDemo.model.Person;
import com.olitech.springDemo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    // add
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    // select
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPersons();
    }

    // select by id
    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id);
    }

}
