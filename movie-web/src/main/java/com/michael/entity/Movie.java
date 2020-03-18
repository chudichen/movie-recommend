package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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

    public static final String FIELD_MOVIE_NAME = "moviename";

    @TableId("movieid")
    private Integer movieId;
    @TableField(FIELD_MOVIE_NAME)
    private String movieName;
    @TableField("showyear")
    private Date showYear;
    @TableField("nation")
    private String nation;
    @TableField("director")
    private String director;
    @TableField("leadactors")
    private String leadActors;
    private String screenwriter;
    private String picture;
    @TableField("averating")
    private Double aveRating;
    @TableField("numrating")
    private Integer numRating;
    private String description;
    @TableField("typelist")
    private String typeList;
    @TableField("backpost")
    private String backPost;
}
