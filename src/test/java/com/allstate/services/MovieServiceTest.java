package com.allstate.services;

import com.allstate.entities.Movie;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@Sql(value = {"/sql/seed.sql"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {
@Autowired
    private MovieService service;

    public void setService(MovieService service) {
        this.service = service;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateMovie() throws Exception {
        Movie before = new Movie();
        before.setTitle("Avengers");
        Movie after = this.service.create(before);
        assertNotNull(after.getId());
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreateMovieNoTitle() throws Exception {
        Movie before = new Movie();
        Movie after = this.service.create(before);
        assertNotNull(after.getId());
    }

    @Test
    public void shouldUpdateMovie() throws Exception {
        Movie before = new Movie();
        before.setTitle("Avengers");
        Movie after = this.service.create(before);

        Movie after2 = this.service.update(after);
        assertEquals(after.getId(), after2.getId());
    }

    @Test
    public void shouldUpdateMovieFail() throws Exception {
        Movie before = new Movie();
        before.setId(1000);
        before.setTitle("Avengers");

        Movie after = this.service.update(before);
        System.out.println("value for after: " + after);
        assertEquals(before.getId(), after.getId());
    }

    @Test
    public void shouldFindByTitle() throws Exception {
        String title = "The Gavengers";

        List<Movie> movies = this.service.findByTitle(title);
        assertTrue(movies.size() > 0);
    }

    @Test
    public void shouldFindByTitleFails() throws Exception {
        String title = "The Avengers";

        List<Movie> movies = this.service.findByTitle(title);
        assertFalse(movies.size() > 0);
    }

}