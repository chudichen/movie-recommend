package com.michael.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Michael Chu
 * @since 2020-03-17 12:38
 */
@Data
public class User {

    private Integer userId;
    private String username;
    private String password;
    private Date registerTime;
    private Date lastLoginTime;
    private String email;
}
