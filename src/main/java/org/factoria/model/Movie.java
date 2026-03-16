package org.factoria.model;

public class Movie {

    private int id;
    private String title;
    private double year;
    private String director;
    private String main_cast;
    private double FilmAffinity_score;
    private String description;
    private String img;
    private String url;
    private double rank;

    public Movie(String title, String director, double FilmAffinity_score) {
        this.title = title;
        this.director = director;
        this.FilmAffinity_score = FilmAffinity_score;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMain_cast() {
        return main_cast;
    }

    public void setMain_cast(String main_cast) {
        this.main_cast = main_cast;
    }

    public double getFilmaffinity_score() {
        return FilmAffinity_score;
    }

    public void setFilmaffinity_score(double filmaffinity_score) {
        this.FilmAffinity_score = filmaffinity_score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}