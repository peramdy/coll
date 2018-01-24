package com.peramdy.controller;

import com.peramdy.service.impl.ClientTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peramdy on 2018/1/23.
 */
@RestController
public class TestController {

    @Autowired
    private ClientTestService clientTestService;

    @RequestMapping("/test")
    public void test() {
        clientTestService.getDto();
    }


}
