package org.factoria.view;

import org.factoria.controller.MovieController;
import org.factoria.model.Movie;

import java.util.List;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
    }

    public void generateMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba el título de la película: ");
        String title = scanner.nextLine();

        System.out.println("Escriba el año de la película: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escriba el director de la película: ");
        String director = scanner.nextLine();

        System.out.println("Escriba el reparto principal: ");
        String main_cast = scanner.nextLine();

        System.out.println("Escriba la puntuación FilmAffinity: ");
        double filmAffinity_score = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escriba la descripción de la película: ");
        String description = scanner.nextLine();

        System.out.println("Escriba la URL de la imagen: ");
        String img = scanner.nextLine();

        System.out.println("Escriba la URL de FilmAffinity: ");
        String url = scanner.nextLine();

        System.out.println("Escriba el ranking: ");
        double rank = scanner.nextDouble();

        Movie movie = new Movie(title, year, director, main_cast, filmAffinity_score, description, img, url, rank);
        movieController.createMovieController(movie);

        scanner.close();
    }

    public void showMovies() {
        List<Movie> movieList = movieController.findAllController();

        for (Movie movie : movieList) {
            System.out.println("title: " + movie.getTitle() + " year: " + movie.getYear() + " director: " + movie.getDirector() + " main_cast: " + movie.getMain_cast() + " filmAffinity_score: " + movie.getFilmAffinity_score() + " description: " + movie.getDescription() + " img: " + movie.getImg() + " url: " + movie.getUrl() + " ranking: " + movie.getRank());
        }
    }
}