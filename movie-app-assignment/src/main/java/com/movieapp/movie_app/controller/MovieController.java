package com.movieapp.movie_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.movieapp.movie_app.entity.Movie;
import com.movieapp.movie_app.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    // Add Movie
    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {
        service.addMovie(movie);
        return "redirect:/";
    }

    // Search by Genre
    @GetMapping("/genre")
    public String searchByGenre(@RequestParam String genre, Model model) {
        List<Movie> list = service.getByGenre(genre);
        model.addAttribute("movies", list);
        return "result";
    }
}