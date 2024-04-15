package com.example.BigData.Repo;

import com.example.BigData.Entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieRepository extends Neo4jRepository<Movie, String> {
@Query("MATCH (s:Movie {uri: $uri}) RETURN s")
Optional<Movie> findByUri(@Param("uri") String uri);
        }