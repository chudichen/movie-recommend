package com.michael.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.michael.entity.RecTab;
import com.michael.mapper.RecTabMapper;
import com.michael.service.RecommendTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Michael Chu
 * @since 2020-03-16 16:44
 */
@Service
public class RecommendTabServiceImpl implements RecommendTabService {

    @Autowired
    private RecTabMapper recTabMapper;

    @Override
    public RecTab getRecTabByUserId(Integer userId) {
        QueryWrapper<RecTab> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userId);
        return recTabMapper.selectOne(queryWrapper);
    }
}
