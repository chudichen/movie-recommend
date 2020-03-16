package com.michael.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael Chu
 * @since 2020-03-16 10:33
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String userHomePage() {
        return "";
    }
}
