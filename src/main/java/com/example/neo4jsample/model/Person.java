package com.example.neo4jsample.model;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

@NodeEntity
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @Getter
    private String id;

    @Required
    @Index(unique = true)
    @NonNull
    @Getter
    @Setter
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
    @JsonIgnoreProperties({"person1","person2"})
    @Getter
    @Setter
    private Collection<SomeRelationship> teammates = new ArrayList<>();

    @Relationship(type = "MANAGES", direction = Relationship.UNDIRECTED)
    @Getter
    @Setter
    private Person manager;

    public void worksWith(SomeRelationship someRelationship) {
        if (someRelationship != null){
            this.teammates.add(someRelationship);
        }
    }
}