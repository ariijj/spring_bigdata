package com.example.BigData.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Getter
@Setter
@Node("Movie")
public class Movie {

    @Id
    private final String id;
    @Property("name")
    private String name;


    public Movie(String id,String name) {
        this.id = id;
        this.name=name;
    }
}
