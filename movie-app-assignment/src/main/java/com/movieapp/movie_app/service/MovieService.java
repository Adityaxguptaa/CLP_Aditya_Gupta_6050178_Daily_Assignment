package com.movieapp.movie_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.movie_app.entity.Movie;
import com.movieapp.movie_app.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    public Movie addMovie(Movie movie) {
        return repo.save(movie);
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public List<Movie> getByGenre(String genre) {
        return repo.findByGenre(genre);
    }

    public void deleteMovie(Long id) {
        repo.deleteById(id);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie existing = repo.findById(id).orElseThrow();
        existing.setMovieName(movie.getMovieName());
        existing.setRating(movie.getRating());
        existing.setGenre(movie.getGenre());
        return repo.save(existing);
    }
}