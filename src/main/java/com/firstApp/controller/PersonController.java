package com.firstApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstApp.person.Person;
import com.firstApp.person.PersonRegistrationRequest;
import com.firstApp.person.PersonValidationRuequest;
import com.firstApp.service.PersonService;

// APIs :
// get all the persons (GET) : localhost:8080/api/v1/persons
// get a special person (GET) : localhost:8080/api/v1/person/{id}
// add a person (POST) : localhost:8080/api/v1   <- give a PersonRegistrationRequest object
// delete a person (DELETE) : localhost:8080/api/v1/person/{id}
//update a person (UPDATE) : localhost:8080/api/v1/updateperson/{id}


@RestController
@RequestMapping("api/v1")
public class PersonController {

    private PersonService personservice;

    public PersonController(PersonService personservice) {
        this.personservice = personservice;
    }

    @GetMapping("persons")
    public List<Person> getPersons() {
        return personservice.getAllPersons();
    }

    @GetMapping("person/{id}")
    public Optional<Person> getperson(@PathVariable("id") Integer personId) {
        return personservice.getOnePerson(personId);
    }

    @PostMapping
    public void addPerson(@RequestBody PersonRegistrationRequest personRegistrationRequest) {
        personservice.addPerson(personRegistrationRequest);
    }

    @DeleteMapping("person/{id}")
    public void deletePersonById(@PathVariable Integer id) {
        personservice.deleteById(id);
    }

    @PutMapping("updateperson/{id}")
    public void updatePerson(@PathVariable(name = "id") Integer id , @RequestBody PersonValidationRuequest personValidationRequest){
        personservice.updatePerson(id, personValidationRequest);
    }

}
