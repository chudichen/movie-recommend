package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 分类
 *
 * @author Michael Chu
 * @since 2020-03-17 11:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("category")
public class Category {

    @TableId("categoryid")
    private Integer categoryId;
    @TableField("category")
    private String category;
}
