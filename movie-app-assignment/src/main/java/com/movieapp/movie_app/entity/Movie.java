package com.movieapp.movie_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Movie name required")
    private String movieName;

    @Min(1)
    @Max(5)
    private double rating;

    @NotBlank(message = "Genre required")
    private String genre;

    // Getters & Setters
    public Long getId() { return id; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}