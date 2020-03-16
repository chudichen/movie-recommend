package com.michael.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.michael.mapper.AlsTabMapper;
import com.michael.mapper.MovieMapper;
import com.michael.entity.AlsTab;
import com.michael.entity.Movie;
import com.michael.service.AlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Michael Chu
 * @since 2020-03-16 10:44
 */
@Service
public class AlsServiceImpl implements AlsService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private AlsTabMapper alsTabMapper;

    @Override
    public List<Movie> selectAlsMoviesByUserId(Integer userId) {
        QueryWrapper<AlsTab> alsQuery = new QueryWrapper<>();
        alsQuery.eq("userId", userId);
        List<AlsTab> alsTabs = alsTabMapper.selectList(alsQuery);
        List<Integer> movieIds = alsTabs.stream().map(AlsTab::getMovieId).collect(Collectors.toList());

        QueryWrapper<Movie> movieQuery = new QueryWrapper<>();
        movieQuery.in("movieid", movieIds);
        return movieMapper.selectList(movieQuery);
    }
}
