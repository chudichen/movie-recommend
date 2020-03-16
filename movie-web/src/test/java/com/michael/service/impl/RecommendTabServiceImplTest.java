package com.michael.service.impl;

import com.michael.BaseTest;
import com.michael.entity.RecTab;
import com.michael.service.RecommendTabService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Michael Chu
 * @since 2020-03-16 16:56
 */

public class RecommendTabServiceImplTest extends BaseTest {

    @Autowired
    private RecommendTabService recommendTabService;

    @Test
    public void getRecTabByUserId() {
        RecTab recTabByUserId = recommendTabService.getRecTabByUserId(1);
        System.out.println(recTabByUserId);
    }
}
