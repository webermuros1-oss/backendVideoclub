package org.factoria.repository;

import org.factoria.config.DBManager;
import org.factoria.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl {

    public void createMovie(Movie movie){
        String querySQLCreate = "INSERT INTO movies(title,year,director,main_cast,filmaffinity_score,description,img,url,ranking) VALUES (?,?,?,?,?,?,?,?,?)";

        try{
            Connection connection = DBManager.InitConnection();

            PreparedStatement statement = connection.prepareStatement(querySQLCreate);
            statement.setString(1, movie.getTitle());
            statement.setInt(2, movie.getYear());
            statement.setString(3, movie.getDirector());
            statement.setString(4, movie.getMain_cast());
            statement.setDouble(5, movie.getFilmAffinity_score());
            statement.setString(6, movie.getDescription());
            statement.setString(7, movie.getImg());
            statement.setString(8, movie.getUrl());
            statement.setDouble(9, movie.getRank());

            statement.execute();

            System.out.println("Película creada");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        } finally {
            DBManager.closeConnection();
        }
    }

    public List<Movie> findAll(){
        List<Movie> movies = new ArrayList<>();
        String querySqlSelectAll = "SELECT * FROM movies";

        try {
            Connection connection = DBManager.InitConnection();
            PreparedStatement statement = connection.prepareStatement(querySqlSelectAll);
            ResultSet response = statement.executeQuery();

            while (response.next()){
                String title = response.getString("title");
                int year = response.getInt("year");
                String director = response.getString("director");
                String main_cast = response.getString("main_cast");
                double filmaffinity_score = response.getDouble("filmaffinity_score");
                String description = response.getString("description");
                String img = response.getString("img");
                String url = response.getString("url");
                double ranking = response.getDouble("ranking");

                Movie movie = new Movie(title, year, director, main_cast, filmaffinity_score, description, img, url, ranking);
                movies.add(movie);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());

        } finally {
            DBManager.closeConnection();
        }

        return movies;
    }
}