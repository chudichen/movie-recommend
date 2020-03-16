package com.michael.service;

import com.michael.entity.RecTab;

/**
 * @author Michael Chu
 * @since 2020-03-16 16:41
 */
public interface RecommendTabService {

    RecTab getRecTabByUserId(Integer userId);
}
