package com.michael.service;

import com.michael.common.Result;

/**
 * @author Michael Chu
 * @since 2020-03-17 12:40
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    Result userLogin(String username, String password);
}
