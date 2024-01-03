package com.liao.template.spring2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Spring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
        // 打印spring boot 版本
        log.info("Spring Boot 版本: {}, Spring 版本: {}",
                org.springframework.boot.SpringBootVersion.getVersion(),
                org.springframework.core.SpringVersion.getVersion());
    }

}
