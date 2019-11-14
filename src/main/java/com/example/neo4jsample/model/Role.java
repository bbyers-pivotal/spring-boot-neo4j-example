package com.example.neo4jsample.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "TEAMMATE")
public class Role {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @Property
    private String name;
    @StartNode
    private Person person1;
    @EndNode
    private Person person2;
}
