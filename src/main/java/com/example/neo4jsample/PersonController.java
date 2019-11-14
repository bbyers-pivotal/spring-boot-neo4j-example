package com.example.neo4jsample;

import com.example.neo4jsample.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public List<Person> getPerson() {
        return personRepository.getAllByName("Brian");
    }

    @GetMapping("/addPerson")
    public Person addPerson() {
        Person p = new Person("Brian");
        personRepository.save(p);
        return p;
    }

    @GetMapping("/addPerson2")
    public Person addPerson2() {
        Person p = new Person("Frank");
        personRepository.save(p);
        return p;
    }

    @GetMapping("/makeFriends")
    public Person makeFriends() {
        Person p1 = personRepository.findByName("Brian");
        Person p2 = personRepository.findByName("Frank");
//        p1.worksWith(p2);
//        personRepository.save(p1);
        return p1;
    }
}
