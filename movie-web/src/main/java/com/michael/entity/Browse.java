package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 浏览记录
 *
 * @author Michael Chu
 * @since 2020-03-17 11:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("browse")
public class Browse {

    @TableId("browseid")
    private Integer browseId;
    @TableField("userid")
    private Integer userId;
    @TableField("movieids")
    private String movieIds;
    @TableField("browsetime")
    private Date browseTime;
}
