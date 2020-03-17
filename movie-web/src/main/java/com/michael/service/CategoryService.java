package com.michael.service;

import com.michael.common.Result;

/**
 * 分类标签
 *
 * @author Michael Chu
 * @since 2020-03-17 12:40
 */
public interface CategoryService {

    /**
     * 获取所有分类标签
     *
     * @return {@link Result}
     */
    Result getAllCategory();
}
