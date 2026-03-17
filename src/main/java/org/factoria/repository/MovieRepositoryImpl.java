package org.factoria.repository;

import org.factoria.config.DBManager;
import org.factoria.model.Movie;

import java.sql.Connection;
import java.sql.Statement;

public class MovieRepositoryImpl {

    public void createMovie(Movie movie){

        String querySQLCreate = "INSERT INTO movies(title, year, director, main_cast, filmaffinity_score, description, img, url, ranking) VALUES ('"
                + movie.getTitle() + "',"
                + movie.getYear() + ",'"
                + movie.getDirector() + "','"
                + movie.getMain_cast() + "',"
                + movie.getFilmAffinity_score() + ",'"
                + movie.getDescription() + "','"
                + movie.getImg() + "','"
                + movie.getUrl() + "',"
                + movie.getRank() + ")";

        try{
            Connection connection = DBManager.InitConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(querySQLCreate);
            System.out.println("Película creada");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        } finally {
            DBManager.closeConnection();
        }
    }
}