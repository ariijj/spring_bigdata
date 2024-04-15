package com.example.BigData.Service;

import com.example.BigData.Entity.Movie;
import com.example.BigData.Repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired

    private MovieRepository movieRepository;



    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> findByUri(String uri) {
        return movieRepository.findByUri(uri);
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
