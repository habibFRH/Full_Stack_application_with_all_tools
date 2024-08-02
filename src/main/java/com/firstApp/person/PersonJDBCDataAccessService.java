package com.firstApp.person;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository("jdbc")
public class PersonJDBCDataAccessService implements PersonDAOInterface {

    private final JdbcTemplate jdbcTemplate;  
    private final PersonRowMapper personRowMapper;

    public PersonJDBCDataAccessService(JdbcTemplate jdbcTemplate,PersonRowMapper personRowMapper){
        this.jdbcTemplate = jdbcTemplate;
        this.personRowMapper = personRowMapper;
    }

    @Override
    public List<Person> getAllPersons() {
        var sql = """
                SELECT id, name, email, password, age FROM customer
                """;
        return jdbcTemplate.query(sql,personRowMapper);
    }

    @Override
    public Optional<Person> getOnePerson(Integer id) {
        var sql = """
                SELECT id , name , email , password , age 
                FROM customer 
                WHERE id = ? 
                """;
        return jdbcTemplate.query(sql, personRowMapper , id)
        .stream()
        .findFirst();
    }

    @Override
    public void addPerson(Person person) {
        var sql = """
                INSERT INTO customer (name, email, password, age) VALUES (?,?,?,?)
                """;
        jdbcTemplate.update(sql, person.getName(), person.getEmail(),person.getPassword(), person.getAge());
    }

    @Override
    public boolean existPersonByEmail(String email) {
        var sql = """
                SELECT count(id)
                FROM customer 
                WHERE email = ?
                """;
        Integer countEmail = jdbcTemplate.queryForObject(sql,Integer.class, email);
        return countEmail != null && countEmail > 0;
    }

    @Override
    public boolean existPersonById(Integer id) {
        var sql = """
                SELECT count(id)
                FROM customer 
                WHERE id = ?
                """;
        Integer countId = jdbcTemplate.queryForObject(sql,Integer.class,id);
        return countId != null && countId > 0; 
    }

    @Override
    public void deletePersonById(Integer id) {
        var sql = """
                DELETE FROM customer 
                WHERE id = ?
                """;
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Person getByIdPerson(Integer id) {
        var sql = """
                SELECT id, name, email, password, age
                FROM customer
                WHERE id = ?
                """;
        return jdbcTemplate.queryForObject(sql,personRowMapper,id);
    }

    @Override
    public void updatePerson(Person person) {
        var sql = """
                UPDATE customer 
                SET name = ?, email = ?, password = ?, age = ? 
                WHERE id = ?
                """;
        jdbcTemplate.update(sql, person.getName(),person.getEmail(),person.getPassword(),person.getAge(),person.getId());
    }
    
}
