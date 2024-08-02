package com.firstApp.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.firstApp.exception.DuplicateResourceException;
import com.firstApp.exception.ResourceNotFoundException;
import com.firstApp.exception.SuccessfullRequestexception;
import com.firstApp.exception.ValidationRequestException;

@Service
public class PersonService {
    private PersonDAOInterface personDAOInterface;

    public PersonService(@Qualifier("jdbc") PersonDAOInterface personDAOInterface) {
        this.personDAOInterface = personDAOInterface;
    }

    public List<Person> getAllPersons() {
        return Optional.ofNullable(personDAOInterface.getAllPersons())
                .orElseThrow(
                        () -> new ResourceNotFoundException("the database is empty"));
    }

    public Optional<Person> getOnePerson(Integer id) {
        return Optional.ofNullable(personDAOInterface.getOnePerson(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                String.format("The person with the id [%d] does not exist", id))));
    }

    public void addPerson(PersonRegistrationRequest personRegistrationRequest) {
        if (personDAOInterface.existPersonByEmail(personRegistrationRequest.email())) {
            throw new DuplicateResourceException("email already taken");
        }
        Person person = new Person(
                personRegistrationRequest.name(),
                personRegistrationRequest.email(),
                personRegistrationRequest.password(),
                personRegistrationRequest.age());
        personDAOInterface.addPerson(person);
        throw new SuccessfullRequestexception("Person added successfully");
    }

    public void deleteById(Integer id) {
        if (!personDAOInterface.existPersonById(id)) {
            throw new ResourceNotFoundException(String.format("The person with the id [%d] does not exist", id));
        }
        personDAOInterface.deletePersonById(id);
        throw new SuccessfullRequestexception("person deleted successfully");
    }

    public void updatePerson(Integer id, PersonValidationRuequest personValidationRuequest) {

        if (!personDAOInterface.existPersonById(id)) {
            throw new ResourceNotFoundException(String.format("The person with the id [%d] does not exist"));
        }

        Person person = personDAOInterface.getByIdPerson(id);
        boolean changes = false;

        if (personValidationRuequest.name() != null && !person.getName().equals(personValidationRuequest.name())) {
            person.setName(personValidationRuequest.name());
            changes = true;
        }

        if (personValidationRuequest.email() != null && !person.getEmail().equals(personValidationRuequest.email())) {
            if (personDAOInterface.existPersonByEmail(personValidationRuequest.email())) {
                throw new ValidationRequestException("The email is already taken by another person");
            }
            person.setEmail(personValidationRuequest.email());
            changes = true;
        }

        if (personValidationRuequest.password() != null
                && !person.getPassword().equals(personValidationRuequest.password())) {
            person.setPassword(personValidationRuequest.name());
            changes = true;
        }

        if (personValidationRuequest.age() != null && person.getAge() != personValidationRuequest.age()) {
            person.setAge(personValidationRuequest.age());
            changes = true;
        }

        if (!changes) {
            throw new ValidationRequestException("no data changes found");
        }

        personDAOInterface.updatePerson(person);
        throw new SuccessfullRequestexception("Person updated successfully");
    }

}
