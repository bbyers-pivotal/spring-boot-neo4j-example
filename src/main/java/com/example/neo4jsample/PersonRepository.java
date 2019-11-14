package com.example.neo4jsample;

import com.example.neo4jsample.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;
import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, String> {
    public Collection<Person> getAllByName(String name);
    public Person findByName(String name);

//    @Query("MATCH (p:Person)<-[r:TEAMMATES]-(a:Person) RETURN m,r,a LIMIT {limit}")
//    @Query("MATCH (:Actor {name:{name}})-[:ACTED_IN]->(m:Movie) return m")
//    public boolean alreadyExists(Person a, Person b);
}

