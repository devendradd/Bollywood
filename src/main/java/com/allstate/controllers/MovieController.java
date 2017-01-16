package com.allstate.controllers;

import com.allstate.entities.Movie;
import com.allstate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {


    //post /movies
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Movie create (@RequestBody Movie movie){
        return this.movieService.create(movie);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    public Movie update (@RequestBody Movie movie){
        return this.movieService.update(movie);
    }

    @RequestMapping(value = {"", "/findbyid/{id}"}, method = RequestMethod.GET)
    public Movie read (@PathVariable int id){
        return this.movieService.read(id);
    }

    @RequestMapping(value = {"", "/findbytitle/{title}"}, method = RequestMethod.GET)
    public List<Movie> findByTitle (@PathVariable String title){
        System.out.println("value for MovieController.title: " + title);
        return this.movieService.findByTitle(title);
    }

    //delete /movies
    public void delete (){

    }

}
