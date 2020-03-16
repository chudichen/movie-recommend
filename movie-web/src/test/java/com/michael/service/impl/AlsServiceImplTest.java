package com.michael.service.impl;


import com.michael.BaseTest;
import com.michael.entity.Movie;
import com.michael.service.AlsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Michael Chu
 * @since 2020-03-16 14:43
 */

public class AlsServiceImplTest extends BaseTest {

    @Autowired
    private AlsService alsService;

    @Test
    public void selectAlsMoviesByUserId() {
        List<Movie> movies = alsService.selectAlsMoviesByUserId(1);
        System.out.println(movies);
    }
}
