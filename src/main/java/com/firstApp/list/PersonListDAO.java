package com.firstApp.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.firstApp.person.Person;
import com.firstApp.person.PersonDAOInterface;

@Repository("list")
public class PersonListDAO implements PersonDAOInterface {

    static final List<Person> persons;

    static {
        Person sidou = new Person(1, "sidou", "sidou@gmail.com", "password123", 23);
        Person mohamed = new Person(2, "mohamed", "mohamed@gmail.com", "password123", 23);
        persons = new ArrayList<>();
        persons.add(sidou);
        persons.add(mohamed);
    }

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public Optional<Person> getOnePerson(Integer id) {
        Optional<Person> person = persons.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        return person;
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public boolean existPersonByEmail(String email) {
        return persons.stream()
        .anyMatch(p -> p.getEmail().equals(email));
    }


    @Override
    public void deletePersonById(Integer id) {
        persons.stream()
        .filter(
            p -> p.getId() == id)
        .findFirst()
        .ifPresent(person -> persons.remove(person));       ;
    }

    @Override
    public boolean existPersonById(Integer id) {
        return persons.stream()
        .anyMatch(
            p -> p.getId() == id
        );
    }

    @Override
    public void updatePerson(Person person) {
        persons.set(person.getId(), person);
    }

    @Override
    public Person getByIdPerson(Integer id) {
        return persons.stream()
        .filter(
            p -> p.getId() == id
        )
        .findFirst()
        .orElse(null)
        ;
    }

}
