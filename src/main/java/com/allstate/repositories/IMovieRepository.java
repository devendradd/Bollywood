package com.allstate.repositories;

import com.allstate.entities.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMovieRepository extends CrudRepository<Movie, Integer>{
    public List<Movie> findByTitle(String title);
}
