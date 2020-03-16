package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Michael Chu
 * @since 2020-03-16 10:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("movie")
public class Movie {
    @TableId("movieid")
    private Integer movieId;

    private String movieName;

    private Date showYear;

    private String nation;

    private String director;

    private String leadActors;

    private String screenwriter;

    private String picture;

    private Double aveRating;

    private Integer numRating;

    private String description;

    private String typeList;

    private String backPost;
}
