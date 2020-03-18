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

    public static final String FIELD_BROWSE_ID = "browseid";
    public static final String FIELD_USER_ID = "userid";
    public static final String FIELD_MOVIE_IDS = "movieids";
    public static final String FIELD_BROWSE_TIME = "browsetime";

    @TableId(FIELD_BROWSE_ID)
    private Integer browseId;
    @TableField(FIELD_USER_ID)
    private Integer userId;
    @TableField(FIELD_MOVIE_IDS)
    private String movieIds;
    @TableField(FIELD_BROWSE_TIME)
    private Date browseTime;
}
