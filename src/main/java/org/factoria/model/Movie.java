package org.factoria.model;

public class Movie {

    private int id;
    private String title;
    private int year;
    private String director;
    private String main_cast;
    private double filmAffinity_score;
    private String description;
    private String img;
    private String url;
    private double rank;

    public Movie(String title, int year, String director, String main_cast, double filmAffinity_score, String description, String img, String url, double rank) {
        this.title = title;
        this.year = year;
        this.main_cast = main_cast;
        this.director = director;
        this.filmAffinity_score = filmAffinity_score;
        this.description = description;
        this.img = img;
        this.url = url;
        this.rank = rank;
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

    public int getYear() {
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

    public double getFilmAffinity_score() {
        return filmAffinity_score;
    }

    public void setFilmAffinity_score(double filmAffinity_score) {
        this.filmAffinity_score = filmAffinity_score;
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
