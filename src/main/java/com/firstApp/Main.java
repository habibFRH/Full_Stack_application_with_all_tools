package com.firstApp;

// import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.firstApp.person.PersonRepository;
// import com.github.javafaker.Faker;
// import com.github.javafaker.Name;
// import com.firstApp.person.Person;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    CommandLineRunner runner(PersonRepository personRepository) {
        return args -> {
            // Faker faker = new Faker();
            // Random random = new Random();
            // Name name = faker.name();
            // String fname = name.firstName();
            // String lname = name.lastName();
            

            // Person person = new Person(
            //     fname+" "+lname,
            //     fname+"."+lname+"@gmail.com",
            //     faker.internet().password(),
            //     random.nextInt(18,99)
            // );
            // Person sidou = new Person("sidou", "sidou@gmail.com", "password123", 23);
            // Person mohamed = new Person("mohamed", "mohamed@gmail.com", "password123",23);
            // List<Person> persons = List.of(sidou,mohamed);
            // personRepository.save(person);
        };
    }

}
