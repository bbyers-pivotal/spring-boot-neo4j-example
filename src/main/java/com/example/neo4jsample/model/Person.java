package com.example.neo4jsample.model;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

@NodeEntity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;

    @Required
    @Index(unique = true)
    @NonNull
    private String name;

//    private Person() {
//        // Empty constructor required as of Neo4j API 2.0.5
//    };


    public Person(String name) {
        this.name = name;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
    @JsonIgnoreProperties({"person1","person2"})
//    @JsonIgnoreProperties("person2")
//    @JsonIgnoreProperty("person2")
    public Set<Person> teammates;


//    public void worksWith(Person person) {
//        if (teammates == null) {
//            teammates = new HashSet<>();
//        }
//        teammates.add(person);
//    }

    public String toString() {

        return this.id + ": " + this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                Collections.emptySet()).stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}