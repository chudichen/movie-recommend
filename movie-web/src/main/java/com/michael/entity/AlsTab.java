package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Michael Chu
 * @since 2020-03-16 10:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("alstab")
public class AlsTab {

    @TableId("userid")
    private Integer userId;

    @TableField("movieid")
    private Integer movieId;

    private Double rating;
}
