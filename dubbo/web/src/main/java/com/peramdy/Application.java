package com.peramdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by peramdy on 2018/1/22.
 */
@SpringBootApplication
//@ImportResource({"classpath:dubbo/dubbo-annotation.xml"})
@ImportResource({"classpath:dubbo/dubbo-manual.xml"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        /**
         * start boot
         */
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
