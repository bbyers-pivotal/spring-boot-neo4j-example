package com.example.neo4jsample;

import com.example.neo4jsample.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, String> {
    public List<Person> getAllByName(String name);
    public Person findByName(String name);
}

