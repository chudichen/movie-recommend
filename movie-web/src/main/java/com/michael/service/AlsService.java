package com.michael.service;

import com.michael.entity.Movie;

import java.util.List;

/**
 * @author Michael Chu
 * @since 2020-03-16 10:37
 */
public interface AlsService {

    List<Movie> selectAlsMoviesByUserId(Integer userId);
}
