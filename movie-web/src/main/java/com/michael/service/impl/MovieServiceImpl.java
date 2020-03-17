package com.michael.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.michael.common.Result;
import com.michael.entity.Movie;
import com.michael.entity.SimilarTab;
import com.michael.entity.TopDefaultMovie;
import com.michael.mapper.BrowseMapper;
import com.michael.mapper.MovieMapper;
import com.michael.mapper.SimilarTabMapper;
import com.michael.mapper.TopDefaultMovieMapper;
import com.michael.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author Michael Chu
 * @since 2020-03-17 13:45
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final String DEFAULT_LIMIT = "limit 5";

    private final MovieMapper movieMapper;
    private final SimilarTabMapper similarTabMapper;
    private final BrowseMapper browseMapper;
    private final TopDefaultMovieMapper topDefaultMovieMapper;

    public MovieServiceImpl(MovieMapper movieMapper,
                            SimilarTabMapper similarTabMapper,
                            BrowseMapper browseMapper,
                            TopDefaultMovieMapper topDefaultMovieMapper) {
        this.movieMapper = movieMapper;
        this.similarTabMapper = similarTabMapper;
        this.browseMapper = browseMapper;
        this.topDefaultMovieMapper = topDefaultMovieMapper;
    }

    @Override
    public Result selectTopDefaultMovie(int limit) {
        QueryWrapper<TopDefaultMovie> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit " + limit);
        List<TopDefaultMovie> topDefaultMovies = topDefaultMovieMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(topDefaultMovies)) {
            return Result.build(400, "获取电影信息错误");
        }
        return Result.ok(topDefaultMovies);
    }

    @Override
    public Result sortMovieByCategory() {
        return null;
    }

    @Override
    public Result sortMovieByMovieId(int id) {
        Movie movie = movieMapper.selectById(id);
        if (Objects.isNull(movie)) {
            return Result.build(400, "获取电影信息错误");
        }
        return Result.ok(movie);
    }

    @Override
    public Result select5SimilarMoviesById(int id) {
        QueryWrapper<SimilarTab> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SimilarTab.FIELD_ITEMID1, id);
        queryWrapper.orderByDesc(SimilarTab.FIELD_SIMILAR);
        queryWrapper.last(DEFAULT_LIMIT);
        List<SimilarTab> similarTabs = similarTabMapper.selectList(queryWrapper);
        return Result.ok(similarTabs);
    }

    @Override
    public int boolUserUnlikeMovie(int userId, String movieId) {
        return 0;
    }

    @Override
    public void insertUserFavouriteMovie() {

    }

    @Override
    public Movie getMovieByMovieId(Integer id) {
        return null;
    }

    @Override
    public List<Movie> selectMoviesByName(String movieName) {
        return null;
    }

    @Override
    public String select5SimilarMovies(int id) {
        return null;
    }
}
