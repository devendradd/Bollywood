package com.allstate.services;

import com.allstate.entities.Movie;
import com.allstate.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository repository;

    public void setRepository(IMovieRepository repository) {
        this.repository = repository;
    }

    public Movie create(Movie a){
        return this.repository.save(a);
    }

    public Movie update(Movie m){
        return this.repository.save(m);
    }

    public Movie read(int id) {
        return this.repository.findOne(id);
    }

    public List<Movie> findByTitle(String title) {
        System.out.println("value for MovieService.title: " + title);
        return this.repository.findByTitle(title);
    }
}
