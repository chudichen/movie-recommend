package com.michael.service.impl;

import com.michael.BaseTest;
import com.michael.common.Result;
import com.michael.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Michael Chu
 * @since 2020-03-17 14:15
 */
@Slf4j
public class MovieServiceImplTest extends BaseTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void selectTopDefaultMovie() {
    }

    @Test
    public void sortMovieByCategory() {
    }

    @Test
    public void sortMovieByMovieId() {
    }

    @Test
    public void select5SimilarMoviesById() {
        Result result = movieService.select5SimilarMoviesById(1);
        log.info("result is : {}", result);
    }

    @Test
    public void boolUserUnlikeMovie() {
    }

    @Test
    public void insertUserFavouriteMovie() {
    }

    @Test
    public void getMovieByMovieId() {
    }

    @Test
    public void selectMoviesByName() {
    }

    @Test
    public void select5SimilarMovies() {
    }
}
