package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 观看
 *
 * @author Michael Chu
 * @since 2020-03-17 11:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("review")
public class Review {

    @TableId("reviewid")
    private Integer reviewId;
    @TableField("userid")
    private Integer userId;
    @TableField("movieid")
    private Integer movieId;
    @TableField("content")
    private String content;
    @TableField("star")
    private Double star;
    @TableField("reviewtime")
    private Date reviewTime;
    @TableField("picture")
    private String picture;
}
