package com.firstApp.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jpa")
public class PersonDAO implements PersonDAOInterface {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getOnePerson(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public boolean existPersonByEmail(String email) {
        return personRepository.existsPersonByEmail(email);
    }

    @Override
    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public boolean existPersonById(Integer id) {
        return personRepository.existsById(id);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person getByIdPerson(Integer id) {
        return personRepository.getReferenceById(id);
    }

}
