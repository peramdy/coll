package com.peramdy.service;

import com.peramdy.dto.TestDto;
import com.peramdy.service.inf.ITestService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author peramdy on 2018/1/22.
 */
@Service
//@com.alibaba.dubbo.config.annotation.Service(interfaceName = "com.peramdy.service.inf.ITestService", timeout = 20000)
public class TestService implements ITestService {

    @Override
    public TestDto getDto() {
        TestDto dto = new TestDto();
        dto.setAreaCode("021");
        dto.setAudioUrl("http://www.baidu.com");
        dto.setCreateTime(new Date());
        return dto;
    }
}
