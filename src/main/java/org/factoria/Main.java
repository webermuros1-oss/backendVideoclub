package org.factoria;


import org.factoria.config.DBManager;
import org.factoria.model.Movie;
import org.factoria.repository.MovieRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();

        Movie movie1 = new Movie("Los otros", "2001", 25.35);
        movieRepository.createMovie(movie1);

        Movie movie2 = new Movie("El ultimo superviviente", "2008", 14.25);
        movieRepository.createMovie(movie2);
    }
}
