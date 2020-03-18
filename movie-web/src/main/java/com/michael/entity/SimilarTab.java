package com.michael.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Michael Chu
 * @since 2020-03-17 12:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("similartab")
public class SimilarTab {

    public static final String FIELD_ITEMID1 = "itemid1";
    public static final String FIELD_ITEMID2 = "itemid2";
    public static final String FIELD_SIMILAR = "similar";

    @TableId(FIELD_ITEMID1)
    private Integer itemid1;
    @TableField(FIELD_ITEMID2)
    private Integer itemid2;
    @TableField(FIELD_SIMILAR)
    private Double similar;
}
