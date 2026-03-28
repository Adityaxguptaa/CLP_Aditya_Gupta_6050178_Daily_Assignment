package com.movieapp.movie_app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.movieapp.movie_app.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);
}