package com.michael.service;

import com.michael.common.Result;
import com.michael.entity.Movie;

import java.util.List;

/**
 * @author Michael Chu
 * @since 2020-03-17 12:41
 */
public interface MovieService {

    /**
     * 选择默认的电影5部(暂时用于推荐表中用户推荐电影不足五部的时候增加)
     *
     * @param limit 数量
     * @return
     */
    Result selectTopDefaultMovie(int limit);

    /**
     * 电影排序分类选择20部一次
     *
     * @return
     */
    Result sortMovieByCategory();

    /**
     * 通过id搜索电影
     *
     * @param id 电影id
     * @return
     */
    Result sortMovieByMovieId(int id);

    /**
     * 相似的5部电影
     *
     * @param id
     * @return
     */
    Result select5SimilarMoviesById(int id);

    /**
     * 判断用户对电影的喜爱
     *
     * @param userId
     * @param movieId
     * @return
     */
    boolean boolUserUnlikeMovie(int userId, String movieId);

    /**
     * 添加用户收藏电影
     */
    void insertUserFavouriteMovie();

    /**
     * 通过电影id获取电影
     *
     * @param id
     * @return
     */
    Movie getMovieByMovieId(Integer id);

    /**
     * 通过名称查找电影
     *
     * @param movieName
     * @return
     */
    List<Movie> selectMoviesByName(String movieName);

    /**
     * 用户平均将相似电影写入recTab
     *
     * @param id
     * @return
     */
    String select5SimilarMovies(int id);
}
