package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Michael Chu
 * @since 2020-03-17 12:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("topdefaultmovies")
public class TopDefaultMovie {

    @TableId("id")
    private Integer id;
    @TableField("movieid")
    private Integer movieId;
    @TableField("moviename")
    private String movieName;
}
