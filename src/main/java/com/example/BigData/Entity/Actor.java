package com.example.BigData.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
@Setter
@Getter
@Node("Actor")
public class Actor {
    @Id
    private final String id;
    @Property("name")
    private  String name;
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
    private Movie ACTED_IN;



    public Actor(String id, String name) {
        this.id = id;
        this.name=name;
    }

}
