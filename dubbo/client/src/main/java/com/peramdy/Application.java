package com.peramdy;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

import java.net.UnknownHostException;

/**
 * @author peramdy on 2017/7/12.
 */
@SpringBootApplication
//@ImportResource(value = {"classpath:dubbo/dubbo-manual.xml"})
@ImportResource(value = {"classpath:dubbo/dubbo-annotation.xml"})
public class Application extends SpringBootServletInitializer {


    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }


}
