package com.permady.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peramdy on 2018/1/29.
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("hello socket server");
        return "hello socket server";
    }

}
