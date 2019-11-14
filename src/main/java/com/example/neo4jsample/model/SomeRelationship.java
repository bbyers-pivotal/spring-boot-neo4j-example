package com.example.neo4jsample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "TEAMMATE")
@Data
@NoArgsConstructor
public class SomeRelationship {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @Property
    private String name;
    @StartNode
    private Person person1;
    @EndNode
    private Person person2;

    public SomeRelationship(Person person1, Person person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    public String toString() {
        return this.relationshipId + ": " + this.name;
    }
}
