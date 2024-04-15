package com.example.BigData.Controller;

import com.example.BigData.Entity.Movie;
import com.example.BigData.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/movies")
    public List<Movie> getAllMovie(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{uri}")
    public ResponseEntity<Movie> getMovieByUri(@PathVariable String uri) {
        Optional<Movie> movieOptional = movieService.findByUri(uri);

        return movieOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
