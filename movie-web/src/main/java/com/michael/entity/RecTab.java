package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Michael Chu
 * @since 2020-03-16 16:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rectab")
public class RecTab {

    @TableId("userid")
    private Integer userId;

    @TableField("movieids")
    private String movieIds;
}
