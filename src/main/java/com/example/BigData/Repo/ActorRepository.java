package com.example.BigData.Repo;

import com.example.BigData.Entity.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends Neo4jRepository<Actor, String> {
@Query("MATCH (a:Actor)-[r:ACTED_IN]->(s:Movie {uri: $movieUri}) DELETE r")
    void deleteRegisteredOnRelationship(@Param("serverUri") String serverUri);

        }