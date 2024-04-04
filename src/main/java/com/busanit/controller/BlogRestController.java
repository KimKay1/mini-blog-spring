package com.busanit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogRestController {

    @RequestMapping("/test")
    public String test() {
        return "리액트 연동 테스트";
    }
}
