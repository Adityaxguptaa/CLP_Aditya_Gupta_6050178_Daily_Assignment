package com.movieapp.movie_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

    @GetMapping("/addMovie")
    public String addMoviePage() {
        return "add-movie";
    }

    @GetMapping("/searchMovie")
    public String searchPage() {
        return "search-movie";
    }
}