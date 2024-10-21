package com.firstApp.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstApp.person.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    boolean existsPersonByEmail(String email);
    Person findByEmail(String email);
}
