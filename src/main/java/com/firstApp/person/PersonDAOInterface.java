package com.firstApp.person;

import java.util.List;
import java.util.Optional;

public interface PersonDAOInterface {
    //get
    List<Person> getAllPersons();

    Optional<Person> getOnePerson(Integer id);

    void addPerson(Person person);

    //post
    boolean existPersonByEmail(String email);



    //delete
    boolean existPersonById(Integer id);
    void deletePersonById(Integer id);

    //update
    Person getByIdPerson(Integer id);

    void updatePerson(Person person);
}
