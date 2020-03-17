package com.michael.service;

import com.michael.entity.Browse;

/**
 * 用户浏览
 *
 * @author Michael Chu
 * @since 2020-03-17 11:27
 */
public interface BrowseService {

    /**
     * 根据用户id获取Browse记录
     *
     * @param userId 用户id
     * @return
     */
    Browse getBrowseByUserId(Integer userId);
}
