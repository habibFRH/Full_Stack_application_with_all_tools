package com.firstApp.jdbcTemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.firstApp.person.Person;
import com.firstApp.person.PersonRowMapper;

import firstAppTest.AbstractTestContainers;

public class PersonJDBCDataAccessServiceTest extends AbstractTestContainers{
    private PersonJDBCDataAccessService underTest;
    private final PersonRowMapper personRowMapper = new PersonRowMapper();

    @BeforeEach
    void setUp(){
        underTest = new PersonJDBCDataAccessService(
            getJdbcTemplate(),
            personRowMapper
        );
    }

    @Test
    void testAddPerson() {
        Person personTest = new Person("sidou","mail@gmail.com","password",22);
        underTest.addPerson(personTest);
    }

    @Test
    void testDeletePersonById() {
        underTest.deletePersonById(1);
    }

    @Test
    void testExistPersonByEmail() {
        boolean exist = underTest.existPersonByEmail("mail@gmail.com");
    }

    @Test
    void testExistPersonById() {
        boolean exist = underTest.existPersonById(1);
    }

    @Test
    void testGetAllPersons() {
        underTest.getAllPersons().forEach(System.out::println);
    }

    @Test
    void testGetByIdPerson() {

    }

    @Test
    void testGetOnePerson() {

    }

    @Test
    void testUpdatePerson() {

    }
}
