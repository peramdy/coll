package com.peramdy.controller;

import com.peramdy.dto.TestDto;
import com.peramdy.service.inf.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peramdy on 2018/1/22.
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void hello() {
        TestDto dto = testService.getDto();
        System.out.println("hello dubbox-2.8.4");
    }

}
