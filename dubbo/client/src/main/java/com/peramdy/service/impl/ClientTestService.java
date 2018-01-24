package com.peramdy.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.peramdy.dto.TestDto;
import com.peramdy.service.inf.ITestService;
import org.springframework.stereotype.Service;

/**
 * @author peramdy on 2018/1/23.
 */
@Service
public class ClientTestService {

    @Reference
    private ITestService testService;

    public void getDto() {
        TestDto dto = testService.getDto();
        System.out.println(dto.toString());
        System.out.println("success");
    }

}
