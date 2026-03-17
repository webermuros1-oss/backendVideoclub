package org.factoria.controller;

import org.factoria.model.Movie;
import org.factoria.repository.MovieRepositoryImpl;

public class MovieController {

//EventRepositoryImpl eventRepository = new EventRepositoryImpl();

    private final MovieRepositoryImpl movieRepository;

    public MovieController(MovieRepositoryImpl movieRepository){
        this.movieRepository = movieRepository;
    }

    public void createMovieController(Movie movie){
        movieRepository.createMovie(movie);

    }

}
