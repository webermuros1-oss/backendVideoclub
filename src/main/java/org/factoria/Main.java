package org.factoria;

import org.factoria.controller.MovieController;
import org.factoria.repository.MovieRepositoryImpl;
import org.factoria.view.MovieView;

public class Main {
    public static void main(String[] args) {

        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        MovieController movieController = new MovieController(movieRepository);
        MovieView movieView = new MovieView(movieController);

        movieView.generateMovie();
    }
}