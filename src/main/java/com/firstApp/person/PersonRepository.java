package com.firstApp.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    boolean existsPersonByEmail(String email);
    Person findByEmail(String email);
}
