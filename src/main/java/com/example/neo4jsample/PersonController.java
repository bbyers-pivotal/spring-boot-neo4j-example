package com.example.neo4jsample;

import com.example.neo4jsample.model.Person;
import com.example.neo4jsample.model.SomeRelationship;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public Collection<Person> getPerson() {
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
    public String makeFriends() {
        Person p1 = personRepository.findByName("Brian");
        Person p2 = personRepository.findByName("Frank");

        if (!p1.getTeammates().stream().anyMatch(p -> p.getPerson2().getId().equals(p2.getId()))) {
            SomeRelationship someRelationship = new SomeRelationship(p1, p2);
            someRelationship.setName("mine");
            p1.worksWith(someRelationship);
            personRepository.save(p1);
        }

        return p1.getName() + " is friends with " + p2.getName();
    }

    @GetMapping("/addManager")
    public String addManager() {
        Person p1 = personRepository.findByName("Brian");
        Person p2 = personRepository.findByName("Frank");
        p1.setManager(p2);
        personRepository.save(p1);
        return p2.getName() + " is manager of " + p1.getName();
    }
}
